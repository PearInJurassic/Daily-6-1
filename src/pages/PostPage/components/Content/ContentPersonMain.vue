<template>
    <div class="ContentAll">
        <div :class="personContentClass">
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
    data(){
      return{
        windowWidth:document.documentElement.clientWidth,
      }
    },
    computed:{
      personContentClass(){
        if(this.windowWidth>950){
          return "ContentCenter"
        } else {
          return "small_person_content_all"
        }
      }
    },
    components: {
      ContentPersonInfo,
      ContentPersonFollow,
      ContentPersonTab
    },
    watch: {
      '$store.state.screenWidth': function (val) { //监听屏幕宽度变化
        this.windowWidth = val;
      }
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .ContentCenter {
        .setSize(950px, 600px);

        margin: 0 auto;
    }
</style>