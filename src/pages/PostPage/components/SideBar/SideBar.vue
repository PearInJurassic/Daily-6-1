<template>
    <div>
    <div class="SideBar" id="SideBar">
        <SideBarInformation :userAvatar="userInfo.userImg" :userNickName="userInfo.userName"></SideBarInformation>
        <SideBarRecent :userAvatar="userInfo.userImg"></SideBarRecent>
    </div>
    </div>
</template>

<script>
  import SideBarInformation from "@/pages/PostPage/components/SideBar/SideBarInformation";
  import SideBarRecent from "@/pages/PostPage/components/SideBar/SideBarRecent";

  export default {
    name: "SideBar",
    data() {
      return {
        userInfo:{},
      }
    },
    components: {
      SideBarInformation,
      SideBarRecent
    },
    created() {
      let userID = sessionStorage.getItem('ID');
      // 请求后端数据,查询数据源
      this.axios.get('http://47.107.77.163:8080/demo/getUserInfo',
        {
          params: {
            userId: userID
          }
        }
      )
        .then((response) => {
          this.userInfo = response.data.userInfo.user;
          // console.log(this.userInfo)
        })
        .catch((error) => {
          console.log(error);
        });
    },
  }
</script>

<style lang="less" scoped>
    @outlineColor: #989899;
    .SideBar {
        margin-left: -315px;
        position: fixed;
        z-index: 5;
        width: 315px;
        height: 600px;
        padding-top: 30px;
    }
</style>