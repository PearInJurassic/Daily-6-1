<template>
  <div id="workline">
    <Branch :btnData="{text: '工作'}"></Branch>
  </div>
</template>

<script>
//工作时间轴页面
// @ is an alias to /src
import Branch from '@/components/Timeaxis/Branch.vue'
export default {
  name: 'WorkLine',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>