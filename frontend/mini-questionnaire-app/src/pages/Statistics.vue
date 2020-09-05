<template>
  <div>
    {{this.$store.getters['statisticsStore/getStatistics']}}
  </div>
</template>

<script>
export default {
  name: 'Statistics'
}
</script>
