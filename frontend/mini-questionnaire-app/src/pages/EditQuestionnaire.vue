<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md" v-if="!isChangesApproved">
    <q-form @submit="onSubmit" class="q-gutter-md">
      <q-card class="my-card">
        <q-card-section>
          <q-input outlined v-model="questionnaire.title" label="Название анкеты" />
        </q-card-section>
      </q-card>
      <div class="q-gutter-md"
        v-for="(question, questionIndex) in questionnaire.questions" :key="questionIndex"
      >
        <q-card class="my-card">
          <q-card-section>
            <q-input outlined v-model="question.description" :label="questionIndex+1 + 'й вопрос'" />
            <div class="q-gutter-sm">
              <q-checkbox v-model="question.hasMultipleAnswers" label="На этот вопрос можно дать несколько ответов?" />
            </div>
            <div class="flex flex-center">
              <q-btn label="Добавить вариант ответа" @click="addAnswerOption(questionIndex)" outline color="primary"/>
            </div>
            <div
              v-for="(answer, answerIndex) in question.answerOptions" :key="answerIndex"
            >
              <q-input outlined v-model="answer.description" :label="answerIndex+1 + 'й вариант ответа'" />
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="flex flex-center">
        <q-btn label="Добавить новый вопрос" @click="addQuestion" outline color="primary"/>
      </div>
      <div class="flex flex-center">
        <q-btn label="Сохранить" type="submit" outline color="primary"/>
      </div>
    </q-form>
    </div>
    <div v-else>
      <p class="text-h5 q-mt-lg q-mb-lg q-ml-sm">Изменения успешно сохранены!</p>
      <div class="flex flex-center">
        <q-btn to="/" label="Назад" outline color="primary" />
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'EditQuestionnaire',
  data () {
    return {
      questionnaire: this.getQuestionnaire(),
      isChangesApproved: false
    }
  },
  methods: {
    getQuestionnaire () {
      const questionnaires = this.$store.getters['questionnaireStore/getAllQuestionnaires']
      for (const questionnaire of questionnaires) {
        if (questionnaire.id === +this.$router.currentRoute.params.id) {
          return questionnaire
        }
      }
    },
    async onSubmit () {
      const request = {
        title: this.questionnaire.title,
        questions: this.questionnaire.questions
      }
      const response = await fetch('http://localhost:8080/questionnaires/' + this.questionnaire.id, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + this.$store.getters['userStore/getToken']
        },
        body: JSON.stringify(request)
      })

      if (response.ok) {
        this.isChangesApproved = true
      }
    },
    addAnswerOption (questionIndex) {
      this.questionnaire.questions[questionIndex].answerOptions.push({ description: '' })
    },
    addQuestion () {
      this.questionnaire.questions.push({
        description: 'Новый вопрос',
        hasMultipleAnswers: false,
        answerOptions: [
          { description: 'Первый вариант ответа' },
          { description: 'Второй вариант ответа' }
        ]
      })
    }
  }
}
</script>
