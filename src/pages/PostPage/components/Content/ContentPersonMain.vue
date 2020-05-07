<template>
    <div class="ContentAll">
        <div class="ContentCenter">
            <ContentPersonInfo></ContentPersonInfo>
            <ContentPersonFollow></ContentPersonFollow>
            <ContentPersonTab></ContentPersonTab>
        </div>
    </div>
</template>

<script>
  import ContentPersonInfo from "@/pages/PostPage/components/Content/ContentPersonInfo";
  import ContentPersonFollow from "@/pages/PostPage/components/Content/ContentPersonFollow";
  import ContentPersonTab from "@/pages/PostPage/components/Content/ContentPersonTab";

  export default {
    name: "ContentPersonMain",
    components: {
      ContentPersonInfo,
      ContentPersonFollow,
      ContentPersonTab
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .ContentCenter {
        .setSize(950px, 600px);

        margin: 0 auto;
    }
</style>