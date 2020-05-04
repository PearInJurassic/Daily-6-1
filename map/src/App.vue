<template>
  <div id="app">
  <NavBar>
  </NavBar>

 <div id="Cmap">
  <country>
  </country>
 </div>
  

  </div>
</template>

<script>
// @ is an alias to /src
import NavBar from'@/components/Navigation/NavBar.vue';
import country from '@/components/country.vue';
//import fujian from'@/views/fujian.vue';
export default {
  name: 'Home',
  components: {
    NavBar,
    country,
    //fujian
  }
}




</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#Cap {
  height:800px;
  width:100%;
}


</style>
