<template>
  <div class="home">
    <Branch :btnData="{text: ''}"></Branch>
  </div>
</template>

<script>
//全部时间轴页面
// @ is an alias to /src
import Branch from '@/components/Timeaxis/Branch.vue'
export default {
  name: 'Home',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>
