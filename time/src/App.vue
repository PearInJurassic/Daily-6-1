<template>
  <div id="app">

      <div id="navigation">
        <NavBar></NavBar>
      </div>

      <div id="sidebar">
        <Side></Side>
      </div>
      <div id="maincontent">
        <!-- 路由匹配到的组件将渲染在这里 -->
        <router-view></router-view>
      </div>

  </div>

</template>

<script>

// @ is an alias to /src
import NavBar from'@/components/Navigation/NavBar.vue'
import Side from '@/components/Side.vue'
export default {
  name: 'Home',
  components: {
    NavBar,
    Side
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
  margin: 0;
	padding: 0;
}
#navigation{
  height: 54px; /*高度改为自动高度*/
  width:100%;
  margin-left: 0;
  position: fixed; /*固定在顶部*/
  top: 0;/*离顶部的距离为0*/
  margin-bottom: 5px;
}

#sidebar{
	float: left;/*侧边栏居左，改为right可令侧边栏居右*/
	width: 350px;
  border: 1px solid black;
  height: 100%;
  position: fixed;
  top: 54px;
  bottom: 0;
  left: 0;


}
#maincontent{
  float: right;
	position: fixed;
  top: 54px;
  right: 0;
  bottom: 0;
  left: 351px;
  overflow-y: auto;
}
</style>
