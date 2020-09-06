<template>
  <q-page class="flex flex-center">
      <div class="q-gutter-md">
          <div
            v-for="(user, userIndex) in statistics" :key="userIndex"
          >
            <q-card class="my-card">
              <q-card-section>
                <div>
                  <p class="text-h6 flex-center flex q-gutter-md">{{user[0]}}</p>
                  <div
                    v-for="(pair, pairIndex) in user[1]" :key="pairIndex">
                    <p class="text-h6 flex-center flex q-gutter-md">{{pair}}</p>
                  </div>
                </div>
              </q-card-section>
            </q-card>
          </div>
      </div>
  </q-page>
</template>

<script>
export default {
  name: 'Statistics',
  data () {
    return {
      statistics: this.$store.getters['statisticsStore/getStatistics']
    }
  }
}
</script>
