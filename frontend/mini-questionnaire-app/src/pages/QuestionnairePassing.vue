<template>
  <q-page class="flex flex-center">
    <div v-if="!isPass" class="q-pa-md">
      <div class="q-gutter-md">
        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-item-label class="text-h4">{{questionnaire.title}}</q-item-label>
          <br>
          <div
            v-for="(question, questionIndex) in questionnaire.questions" :key="question.id"
            v-bind:question="question"
          >
            <q-card class="my-card">
              <q-card-section>
                <div>
                  <p class="text-h6 flex-center flex q-gutter-md">{{question.description}}</p>
                  <div
                    v-for="(answer, answerIndex) in question.answerOptions" :key="answer.id">
                    <div class="q-pa-md">
                      <div class="q-gutter-sm text-h6" v-if="question.hasMultipleAnswers">
                        <q-checkbox v-model="multipleAnswersModel[questionIndex][answerIndex]" :label="answer.description" />
                      </div>
                      <div class="text-h6 q-gutter-sm" v-else>
                        <q-radio v-model="singleAnswers[questionIndex]" :val="answer" :label="answer.description" />
                      </div>
                    </div>
                  </div>
                </div>
              </q-card-section>
            </q-card>

          </div>
          <div class="flex flex-center">
            <q-btn label="Отправить" type="submit" outline color="primary"/>
          </div>
        </q-form>
      </div>
    </div>
    <div v-else class="text-h5 q-mt-lg q-mb-lg q-ml-sm">
      <p>Вы успешно прошли анкету!</p>
      <div class="flex flex-center">
      <q-btn to="/" label="На главную" outline color="primary" />
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      questionnaire: this.getQuestionnaire(),
      singleAnswers: [],
      multipleAnswersModel: this.init(),
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
    init () {
      const q = this.getQuestionnaire()
      const arraysForMultiple = []
      let currentIndex = 0
      let tmpArr
      for (const question of q.questions) {
        if (question.hasMultipleAnswers) {
          tmpArr = []
          for (let i = 0; i < question.answerOptions.length; i++) {
            tmpArr.push(false)
          }
          arraysForMultiple[currentIndex++] = tmpArr
        } else arraysForMultiple[currentIndex++] = []
      }
      return arraysForMultiple
    },
    async onSubmit () {
      const allAnswers = []
      for (const answer of this.singleAnswers) {
        if (answer) {
          allAnswers.push(answer)
        }
      }
      for (let i = 0; i < this.multipleAnswersModel.length; i++) {
        for (let j = 0; j < this.multipleAnswersModel[i].length; j++) {
          if (this.multipleAnswersModel[i][j] === true) {
            allAnswers.push(this.questionnaire.questions[i].answerOptions[j])
          }
        }
      }
      const request = {
        answers: allAnswers,
        username: this.$store.getters['userStore/getUsername']
      }
      const response = await fetch('http://localhost:8080/questionnaires/passing', {
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
