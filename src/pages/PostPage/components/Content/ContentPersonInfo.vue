<template>
    <div>
        <div class="PersonInfo">
            <div class="el-avatar"
            size="18"
            ></div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "ContentPersonInfo"
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .PersonInfo {
        .setSize(950px,230px);
        .setBorder();
        background-color: white;
    }
</style>