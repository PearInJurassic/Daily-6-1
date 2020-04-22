<template>
    <div class="NavOption">
        <NavOptionChild><img src="../../assets/NavBar/Location.png" alt="可视化地图"></NavOptionChild>
        <NavOptionChild><img src="../../assets/NavBar/TimeLine.png" alt="时间轴"></NavOptionChild>
        <NavOptionChild><img src="../../assets/NavBar/PersonSpace.png" alt="个人空间"></NavOptionChild>
    </div>
</template>

<script>
    import NavOptionChild from "@/components/Navigation/NavOptionChild";
  export default {
    name: "NavOption",
    components:{
      NavOptionChild,
    }
  }
</script>

<style scoped lang="less">
    .NavOption {
        max-width: 520px;
        min-width: 175px;
        display: flex;
        justify-content: right;
    }
</style>