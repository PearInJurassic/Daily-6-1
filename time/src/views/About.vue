<template>
  <div id="about">
    <Branch :btnData="{text: '日常'}"></Branch>
  </div>
</template>
<script>

// @ is an alias to /src
import Branch from '@/components/Timeaxis/Branch.vue'
export default {
  name: 'About',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>
