<template>
  <q-page-container>
    <q-page class="flex flex-center">
      <div v-if="this.$store.getters['userStore/getToken'] === ''">
        <div class="q-pa-md q-gutter-sm">
          <q-btn to="/login" label="Войти" outline color="primary" />
          <q-btn to="/register" label="Регистрация" outline color="primary" />
        </div>
      </div>
      <div v-else>
        <q-btn to="/questionnaires" label="Выбрать анкету" outline color="primary" />
        <div v-if="this.$store.getters['userStore/getUserRoles'].indexOf('ADMIN') !== -1">
          <q-btn to="/questionnaire" label="Создать анкету" outline color="primary" />
        </div>
      </div>
    </q-page>
  </q-page-container>
</template>

<script>
export default {
  name: 'Main'
}
</script>
