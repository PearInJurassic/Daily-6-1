<template>
    <div class="NavBar">
        <div class="MidDiv">
            <NavLogo></NavLogo>
            <NavSearch v-if="visible"></NavSearch>
            <NavOption></NavOption>
        </div>
    </div>
</template>

<script>
  import NavLogo from "@/components/Navigation/NavLogo";
  import NavSearch from "@/components/Navigation/NavSearch";
  import NavOption from "@/components/Navigation/NavOption";
  export default {
    name: "NavBar",
    data() {
      return {
        windowWidth: document.documentElement.clientWidth,
      }
    },
    computed:{
      visible(){
        if(this.windowWidth <650){
          return false;
        }
        return true;
      }
    },
    components: {
      NavLogo,
      NavSearch,
      NavOption
    },
    methods:{
      /**
       * @description 进行欢迎信息的初始化
       */
      init() {
        let isFirstLoginFlag =sessionStorage.getItem("isFirstLogin");
        this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`,{
          params:{
            userId:sessionStorage.getItem("ID")
          }
        }).then((response) =>{
          if( isFirstLoginFlag == 1 ) {
            let userNickName = response.data.userInfo.user.userName;
            this.$notify({
              title: 'HI',
              message: `欢迎回来，亲爱的${userNickName}`
            });
            sessionStorage.setItem("isFirstLogin",0)
          }
        })
      }
    },
    created() {
      this.init()
    },
    watch:{
      '$store.state.screenWidth':function(val){ //监听屏幕宽度变化
        this.windowWidth=val;
      }
    }
  }
</script>

<style lang="less" scoped>
    @color: white;
    @layout: center;
    @borderColor:#989899;

    .NavStyle(@padding:0 20px,@height:54px,@width:100%) {
        display: flex;
        height: @height;
        width: @width;
        padding: @padding;
    }

    .MidDiv {
        .NavStyle();
        width: 100%;
        align-items: center;
        display: flex;
        justify-content: space-between;
        max-width: 975px;
        margin: 0 auto;
    }

    .NavBar {
        .NavStyle();
        position: fixed;
        z-index: 5;
        margin: 0;
        background-color: @color;
        border-bottom: solid 1px @borderColor;
        border-top: solid 1px @borderColor;
        align-items: center;
        box-shadow: 0 0 3px #2c2d2c;
    }

</style>