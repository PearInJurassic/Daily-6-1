<template>
    <div class="ContentAll">
        <div class="ContentCenter">
            <ContentPersonInfo></ContentPersonInfo>
        </div>
    </div>
</template>

<script>
    import ContentPersonInfo from "@/pages/PostPage/components/Content/ContentPersonInfo";
  export default {
    name: "ContentPersonMain",
    components:{
      ContentPersonInfo
    }
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .ContentCenter {
        .setSize(950px,600px);
        .setBorder();
        background-color: red;
        margin: 0 auto;
    }
</style>