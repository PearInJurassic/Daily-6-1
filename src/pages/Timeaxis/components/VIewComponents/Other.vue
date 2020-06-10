<template>
  <div id="other">
    <Branch :btnData="{text: '吃喝玩乐'}"></Branch>
  </div>
</template>

<script>
//吃喝玩乐时间轴页面
// @ is an alias to /src
import Branch from "@/pages/Timeaxis/components/Branch";
export default {
  name: 'Other',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>