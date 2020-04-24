<template>
    <div id="app">
        <PostPanel v-if="isEditPanelShow"></PostPanel>
        <Nav-bar></Nav-bar>
        <div class="blank" style="padding-top: 55px"></div>
        <PageCenterPost></PageCenterPost>
    </div>
</template>

<script>
  import Bus from '@/JS/bus.js'
  import NavBar from '@/components/Navigation/NavBar'
  import PageCenterPost from "@/components/PageCenterPost/PageCenterPost";
  import PostPanel from "@/components/Panel/PostPanel";

  export default {
    name: 'App',
    data() {
      return {
        isEditPanelShow: false,
      }
    },
    components: {
      PostPanel,
      NavBar, PageCenterPost
    },
    mounted() {
      Bus.$on("showEditPanel", () => {
        this.isEditPanelShow = true;
      });
      Bus.$on("closeEditPanel", () => {
        this.isEditPanelShow = false;
        console.log("success");
      })
    }
  }
</script>

<style lang="less">
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
    }

    body {
        border: 0;
        margin: 0;
    }

    #center {
        max-width: 1000px;
        display: flex;
        justify-content: right;
        margin: 0 auto;
    }

    .SpaceForSideBar {
        width: 315px;
        padding-top: 30px;
    }
</style>
