<template>
  <div id="app">
    <Nav-bar></Nav-bar>
  </div>
</template>

<script>
import NavBar from './components/Navigation/NavBar'
export default {
  name: 'App',
  components: {
    NavBar,
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
</style>
