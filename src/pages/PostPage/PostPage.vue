<template>
    <div id="PostPage">
        <PostPanel v-show="isEditPanelShow"></PostPanel>
        <Nav-bar></Nav-bar>
        <div class="blank" style="padding-top: 55px"></div>
        <router-view v-if="isRouterAlive">
            <PageCenterPost></PageCenterPost>
        </router-view>
    </div>
</template>

<script>
  import Bus from '@/JS/bus.js'
  import NavBar from '@/components/Navigation/NavBar'
  import PageCenterPost from "@/pages/PostPage/components/PageCenter/PageCenterPost";
  import PostPanel from "@/pages/PostPage/components/Panel/PanelPostEdit";

  export default {
    name: 'PostPage',
    provide() {
      return {
        reload: this.reload
      }
    },
    data() {
      return {
        isRouterAlive: true,
        isEditPanelShow: false,
      }
    },
    components: {
      PostPanel,
      NavBar, PageCenterPost,
    },
    methods: {
      reload() {
        this.isRouterAlive = false
        this.$nextTick(function () {
          this.isRouterAlive = true;
        })
      }
    },
    mounted() {
      Bus.$on("showEditPanel", () => {
        this.isEditPanelShow = true;
      });
      Bus.$on("finishEdit", (flag) => {
        if (flag === "close") {
          this.isEditPanelShow = false;
        } else if (flag === "finish") {
          this.isEditPanelShow = false;
        }
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
