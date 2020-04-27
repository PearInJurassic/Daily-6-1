<template>
    <div class="NavOption">
        <slot>
            <NavOptionChild><img alt="匿名状态" src="../../assets/NavBar/Anonymous.png"></NavOptionChild>
            <NavOptionChild><img alt="可视化地图" src="../../assets/NavBar/Location.png"></NavOptionChild>
            <NavOptionChild><img alt="时间轴" src="../../assets/NavBar/TimeLine.png"></NavOptionChild>
            <NavOptionChild><img alt="个人空间" src="../../assets/NavBar/PersonSpace.png"></NavOptionChild>
        </slot>
    </div>
</template>

<script>
  import NavOptionChild from "@/components/Navigation/NavOptionChild";

  export default {
    name: "NavOption",
    components: {
      NavOptionChild,
    }
  }
</script>

<style lang="less" scoped>
    .NavOption {
        max-width: 520px;
        min-width: 175px;
        display: flex;
        justify-content: right;
    }
</style>