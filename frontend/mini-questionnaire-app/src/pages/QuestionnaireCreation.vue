<template>
  <div class="q-pa-md" v-if="!isCreated">
    <div class="q-gutter-md" style="max-width: 300px">
      <q-form @submit="onSubmit" class="q-gutter-md">
        <q-input outlined v-model="title" label="Название анкеты" />
        <q-btn label="Добавить новый вопрос" @click="addQuestion" outline color="primary"/>
        <div
          v-for="(question, questionIndex) in questions" :key="questionIndex"
        >
          <div class="q-gutter-sm">
            <q-checkbox v-model="question.hasMultipleAnswers" label="На этот вопрос можно дать несколько ответов?" />
          </div>
          <q-input outlined v-model="question.description" :label="questionIndex+1 + 'й вопрос'" />
          <q-btn label="Добавить вариант ответа" @click="addAnswerOption(questionIndex)" outline color="primary"/>
          <div
            v-for="(answer, answerIndex) in question.answerOptions" :key="answerIndex"
          >
            <q-input outlined v-model="answer.description" :label="answerIndex+1 + 'й вариант ответа'" />
          </div>
        </div>
        <div class="flex flex-center">
          <q-btn label="Создать" type="submit" outline color="primary"/>
        </div>
      </q-form>
      <div class="flex flex-center">
        <q-btn to="/" label="Назад" outline color="primary" />
      </div>
    </div>
  </div>
  <div v-else>
    <p>Анкета успешно создана!</p>
    <div class="flex flex-center">
      <q-btn to="/" label="Назад" outline color="primary" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'QuestionnaireCreation',
  data () {
    return {
      isCreated: false,
      title: '',
      questions: [{
        description: 'Первый вопрос',
        hasMultipleAnswers: false,
        answerOptions: [
          { description: 'Первый вариант ответа' },
          { description: 'Второй вариант ответа' }
        ]
      }]
    }
  },
  methods: {
    async onSubmit () {
      const request = {
        title: this.title,
        questions: this.questions
      }
      const response = await fetch('http://localhost:8081/questionnaires', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + this.$store.getters['userStore/getToken']
        },
        body: JSON.stringify(request)
      })

      if (response.ok) {
        this.isCreated = true
      }
    },
    addAnswerOption (questionIndex) {
      this.questions[questionIndex].answerOptions.push({ description: '' })
    },
    addQuestion () {
      this.questions.push({
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
