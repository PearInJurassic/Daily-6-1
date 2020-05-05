<template>
  <div id="about">
    <Branch :btnData="{text: '日常'}"></Branch>
  </div>
</template>
<script>
//日常时间轴页面
// @ is an alias to /src
import Branch from "@/pages/Timeaxis/components/Branch";
export default {
  name: 'About',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>
