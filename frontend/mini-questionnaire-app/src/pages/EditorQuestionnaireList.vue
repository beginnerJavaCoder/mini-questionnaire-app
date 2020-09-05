<template>
  <q-page class="flex flex-center">
    <div
      class="q-pa-md q-gutter-sm"
      v-for="questionnaire in this.$store.getters['questionnaireStore/getAllQuestionnaires']"
      :key="questionnaire.id"
    >
      <q-btn
        :to="{path: '/edit/' + questionnaire.id}"
        outline color="primary">
        <q-item-label>{{ questionnaire.title }}</q-item-label>
      </q-btn>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'QuestionnaireEdition'
}
</script>
