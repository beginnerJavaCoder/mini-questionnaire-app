<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md">
      <div class="q-gutter-md" style="max-width: 300px">
        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-input outlined v-model="username" label="Логин" />
          <q-input outlined v-model="password" type="password" label="Пароль">
          </q-input>
          <div class="flex flex-center">
            <q-btn label="Войти" type="submit" outline color="primary"/>
          </div>
        </q-form>
        <div class="flex flex-center">
          <q-btn to="/" label="На главную" outline color="primary" />
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username: null,
      password: null
    }
  },
  methods: {
    async onSubmit () {
      if (this.username.trim() && this.password.trim()) {
        const request = {
          username: this.username,
          password: this.password
        }
        await this.$store.dispatch('userStore/fetchUserInfo', request)
        await this.$router.push('/')
      }
    }
  }
}
</script>
