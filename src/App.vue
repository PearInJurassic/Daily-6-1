<template>
  <div id="app">
    <Nav-bar></Nav-bar>
    <div id="center">

    <ContentMain></ContentMain>
    <SideBar></SideBar>

    </div>
  </div>
</template>

<script>
import NavBar from './components/Navigation/NavBar'
import ContentMain from "@/components/Content/ContentMain";
import SideBar from "@/components/SideBar/SideBar";
export default {
  name: 'App',
  components: {
    NavBar,ContentMain,SideBar
  }
}
</script>

<style>
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
    margin: 0 auto;
  }
</style>
