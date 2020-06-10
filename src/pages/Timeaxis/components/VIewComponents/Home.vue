<template>
  <div class="home">
    <Branch :btnData="{text: '全部'}"></Branch>
  </div>
</template>

<script>
//全部时间轴页面
// @ is an alias to /src
import Branch from "@/pages/Timeaxis/components/Branch";
export default {
  name: 'Home',
  components: {
    Branch
  },
}


</script>

<style scoped>

</style>
