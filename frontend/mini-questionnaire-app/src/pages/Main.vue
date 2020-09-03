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
        GG my friend!
        {{this.$store.getters['userStore/getToken']}}
      </div>
    </q-page>
  </q-page-container>
</template>

<script>
export default {
  name: 'Main'
}
</script>
