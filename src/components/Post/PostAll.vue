<template>
    <div class="PostContent">
        <div class="PictureContent">

        </div>
    </div>
</template>

<script>
  export default {
    name: "PostAll"
  }
</script>

<style scoped lang="less">
    @import "../../CSS/Common";
    .PostContent {
        .setSize(650px,900px);
        min-height: 900px;
        .setBorder();
    }
    .PictureContent{
        .setSize(650px,750px);
        .setBorder();
    }
</style>