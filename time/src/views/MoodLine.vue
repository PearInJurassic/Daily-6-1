<template>
  <div id="moodline">
    <Branch :btnData="{text: '心情'}"></Branch>
  </div>
</template>

<script>

// @ is an alias to /src
import Branch from '@/components/Timeaxis/Branch.vue'
export default {
  name: 'MoodLine',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>