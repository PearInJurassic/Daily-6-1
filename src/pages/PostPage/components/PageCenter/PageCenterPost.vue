<template>
    <div id="center">
        <ContentMain></ContentMain>
        <div class="SpaceForSideBar" v-if="visible"></div>
        <SideBar v-if="visible"></SideBar>
    </div>
</template>

<script>
  import ContentMain from "@/pages/PostPage/components/Content/ContentPostMain";
  import SideBar from "@/pages/PostPage/components/SideBar/SideBar";

  export default {
    name: "PostPageCenter",
    data() {
      return {
        windowWidth:document.documentElement.clientWidth,
      }
    },
    computed: {
      visible(){
        if(this.windowWidth<960) {
          return false
        }
        return true;
      }
    },
    components: {
      ContentMain,
      SideBar,
    },
    watch:{
      '$store.state.screenWidth':function(val){ //监听屏幕宽度变化
        this.windowWidth=val;
      }
    },
  }
</script>

<style scoped>
    #center {
        display: flex;
        justify-content: center;
    }
</style>