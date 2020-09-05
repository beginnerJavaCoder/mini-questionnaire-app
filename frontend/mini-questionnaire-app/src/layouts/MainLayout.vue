<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-toolbar-title>
          Mini Questionnaire App
        </q-toolbar-title>
        <q-btn
          v-if="this.$store.getters['userStore/getToken']"
          flat
          to="/"
          dense
          @click="logout"
          label="Выйти из аккаунта" />
      </q-toolbar>
    </q-header>
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>

export default {
  name: 'MainLayout',
  methods: {
    logout () {
      this.$store.dispatch('userStore/deleteUserInfo')
    }
  }
}
</script>
