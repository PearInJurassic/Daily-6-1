<template>
  <div id="moodline">
    <Branch :btnData="{text: '心情'}"></Branch>
  </div>
</template>

<script>
//心情时间轴页面
// @ is an alias to /src
import Branch from "@/pages/Timeaxis/components/Branch";
export default {
  name: 'MoodLine',
  components: {
    Branch
  }
}


</script>

<style scoped>

</style>