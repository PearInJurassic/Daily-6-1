<template>
    <div>
        <div class="CommentContent">
            <div class="Avatar">
                <el-avatar></el-avatar>
            </div>
            <div class="Comment">
                <p>{{text}}</p>
            </div>
            <div class="reply"></div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostCommentAll",
    props:{
      text:{
        type:String,
        required:true
      }
    }
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .CommentContent {
        margin: 0 auto;
        padding: 2px 0;
        .setSize(280px,50px);
        display: flex;
        justify-content: left;
    }
</style>