<template>
  <q-page-container>
    <q-page class="flex flex-center">
      <div v-if="this.$store.getters['userStore/getToken'] === ''">
        <div class="q-pa-md q-gutter-sm">
          <q-btn to="/login" label="Войти" outline color="primary" />
          <q-btn to="/register" label="Регистрация" outline color="primary" />
        </div>
      </div>
      <div class="flex flex-center" v-else>
        <q-btn
          to="/questionnaires"
          label="Пройти анкету"
          outline color="primary"
          @click="fetchQuestionnaires"/>
        <div
          v-if="this.$store.getters['userStore/getUserRoles'].indexOf('ADMIN') !== -1">
          <q-btn
            to="/statistics"
            label="Посмотреть ответы пользователей"
            outline color="primary"
            @click="fetchUserAnswers"/>
          <q-btn
            to="/creation"
            label="Создать анкету"
            outline color="primary" />
          <q-btn
            to="/edit"
            label="Редактировать анкету"
            @click="fetchQuestionnaires"
            outline color="primary" />
        </div>
      </div>
    </q-page>
  </q-page-container>
</template>

<script>
export default {
  name: 'Main',
  methods: {
    async fetchQuestionnaires () {
      await this.$store.dispatch('questionnaireStore/fetchQuestionnaires',
        this.$store.getters['userStore/getToken'])
    },
    async fetchUserAnswers () {
      await this.$store.dispatch('statisticsStore/fetchStatistics',
        this.$store.getters['userStore/getToken'])
    }
  }
}
</script>
