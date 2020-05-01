<template>
  <div id="other">
    <Branch :btnData="{text: '吃喝玩乐'}"></Branch>
  </div>
</template>

<script>

// @ is an alias to /src
import Branch from '@/components/Timeaxis/Branch.vue'
export default {
  name: 'Other',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>