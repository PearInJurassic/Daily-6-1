<template>
  <div id="workline">
    <Branch :btnData="{text: '工作'}"></Branch>
  </div>
</template>

<script>
//工作时间轴页面
// @ is an alias to /src
import Branch from "@/pages/Timeaxis/components/Branch";
export default {
  name: 'WorkLine',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>