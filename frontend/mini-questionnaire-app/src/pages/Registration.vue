<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md">
      <div class="q-gutter-md" style="max-width: 300px">
        <div class="text-h6 q-gutter-md">
          <p>{{statusOfRegistration}}</p>
        </div>
        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-input outlined v-model="username" label="Логин" />
          <q-input outlined v-model="password" type="password" label="Пароль">
          </q-input>
          <div class="flex flex-center">
            <q-btn label="Регистрация" type="submit" outline color="primary"/>
          </div>
          <div class="flex flex-center">
            <q-btn to="/" label="На главную" outline color="primary" />
          </div>
        </q-form>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'Registration',
  data () {
    return {
      username: null,
      password: null,
      statusOfRegistration: ''
    }
  },
  methods: {
    async onSubmit () {
      if (this.validateForm()) {
        const request = {
          username: this.username,
          password: this.password
        }
        const response = await fetch('http://localhost:8080/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(request)
        })
        if (response.ok) {
          this.statusOfRegistration = `Пользователь ${this.username} успешно зарегистрирован!`
          this.username = ''
          this.password = ''
        } else {
          this.statusOfRegistration = `Пользователь с логином ${this.username} уже существует!`
        }
      } else {
        this.statusOfRegistration = 'Поля Логин и Пароль не должны быть пустыми!'
        this.username = null
        this.password = null
      }
    },
    validateForm () {
      if (this.username !== null && this.password !== null) {
        return (this.username.trim() && this.password.trim())
      } else {
        return false
      }
    }
  }
}
</script>
