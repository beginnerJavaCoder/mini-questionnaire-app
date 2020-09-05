<template>
  <q-page class="flex flex-center">
    <div v-if="!isPass" class="q-pa-md">
      <div class="q-gutter-md" style="max-width: 300px">
        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-item-label>{{questionnaire.title}}</q-item-label>
          <div
            v-for="(question, questionIndex) in questionnaire.questions" :key="question.id"
            v-bind:question="question"
          >
            <div>
              <p>{{question.description}}</p>
              <div
                v-for="answer in question.answerOptions" :key="answer.id">
                <div class="q-pa-md">
                  <div class="q-gutter-sm">
                    <q-radio v-model="choices[questionIndex]" :val="answer" :label="answer.description" />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="flex flex-center">
            <q-btn label="Отправить" type="submit" outline color="primary"/>
          </div>
        </q-form>
      </div>
    </div>
    <div v-else>
      <p>Вы успешно прошли анкету!</p>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      questionnaire: this.getQuestionnaire(),
      choices: [],
      isPass: false
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
        answers: this.choices,
        username: this.$store.getters['userStore/getUsername']
      }
      const response = await fetch('http://localhost:8081/questionnaires/passing', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + this.$store.getters['userStore/getToken']
        },
        body: JSON.stringify(request)
      })

      if (response.ok) {
        this.isPass = true
      }
    }
  }
}
</script>
