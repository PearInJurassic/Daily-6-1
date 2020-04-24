<template>
  <div id="app">
    <Nav-bar></Nav-bar>
    <div class="blank" style="height: 55px"></div>
    <PostPageCenter></PostPageCenter>
  </div>
</template>

<script>
import NavBar from './components/Navigation/NavBar'
import PostPageCenter from "@/components/PostPageCenter/PostPageCenter";
export default {
  name: 'App',
  components: {
    NavBar,PostPageCenter
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
  body{
    border: 0;
    margin:0;
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
