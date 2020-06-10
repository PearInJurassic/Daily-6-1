<template>
    <div class="NavSearch">
        <input class="SearchBox" type="text" placeholder="搜索" value=""
               @keyup.enter="search"
               v-model="searchContent">
    </div>
</template>

<script>
    import Bus from "@/JS/bus";

  export default {
    name: "NavSearch",
    data() {
      return {
        searchContent:''
      }
    },
    methods:{
      search() {
          if (this.$route.path === "/fujian") {
              //接收接口数据

              //对页面进行渲染（用vuex传递高亮地区id）
              this.axios.get(`${this.GLOBAL.apiUrl}/searchareabycontent`, {
                  params: {
                      contentStr: this.searchContent,
                      areaNameStr: this.$store.state.city_name
                  }
              }).then((response) => {

                  this.$store.commit('setHighLight', response.data.areaList);
                  //console.log("aaaaaa")
                  //console.log(this.$store.state.city_name)
              })
          } else {
              this.axios.get(`${this.GLOBAL.apiUrl}/searchpostbycontent`, {
                  params: {
                      str: this.searchContent
                  }
              }).then((response) => {
                  Bus.$emit("finishSearch", response.data.postList)
                  this.$message({
                      message: '搜索完成',
                      duration: 500,
                      showClose: true,
                  })
              })
          }
      }
    }
  }
</script>

<style scoped lang="less">
    @borderColor:#989899;
    .setNavSearchBorder(@radius:3px) {
        -webkit-border-radius:@radius;
        -moz-border-radius: @radius;
        border-radius: @radius;
    }
    .NavSearch {
        height: 28px;
        width: 975px;
        min-width: 125px;
        display: flex;
        justify-content: center;
        .SearchBox {
            .setNavSearchBorder();
            border: 1px solid @borderColor;
            padding: 3px 10px 3px 26px;
            display: flex;
            max-width: 300px;
            min-width: 150px;
        }
    }

</style>