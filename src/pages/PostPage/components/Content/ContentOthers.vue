<template>
    <div class="ContentAll">
        <div class="ContentCenter">
            <ContentPersonInfo v-bind:isOthers="1">
                <!--                不显示设置和退出按钮-->
                <template v-slot:setting>
                    <div></div>
                </template>
            </ContentPersonInfo>
            <ContentPersonFollow v-bind:isOthers="1"></ContentPersonFollow>
            <ContentPersonTab v-bind:isOthers="1">
<!--                不显示动态面板-->
                <template v-slot:record>
                    <div></div>
                </template>
            </ContentPersonTab>
        </div>
    </div>
</template>

<script>
  import ContentPersonFollow from "@/pages/PostPage/components/Content/ContentPersonFollow";
  import ContentPersonInfo from "@/pages/PostPage/components/Content/ContentPersonInfo";
  import ContentPersonTab from "@/pages/PostPage/components/Content/ContentPersonTab";

  export default {
    name: "CotentOthers",
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