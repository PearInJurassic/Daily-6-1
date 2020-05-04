<template>
    <div>
        <div class="RecentPost">
            <div class="Avatar">
                <el-avatar src=""></el-avatar>
            </div>
            <div class="RecentContent">
                <p>1111111111111</p>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostRecent",

  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .RecentPost {
        margin: 7px auto;
        .setSize(250px, 80px);
        .setBorder();
        display: flex;
        justify-content: left;
    }

    .RecentContent {
        .setSize(190px,50px);
        margin-top: 20px;
        .setBorder();

    }
</style>