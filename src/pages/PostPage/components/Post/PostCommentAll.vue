<template>
    <div>
        <div class="CommentContent"></div>
    </div>
</template>

<script>
  export default {
    name: "PostCommentAll"
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .CommentContent {
        margin: 0 auto;
        padding: 2px 0;
        .setSize(280px,50px);
        background-color: #5daf34;
    }
</style>