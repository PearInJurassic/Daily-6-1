<template>
    <div>
        <div class="RecentPost">
            <div class="Avatar">
                <el-avatar :src="posterInfo.userImg" @error="errHandler"></el-avatar>
            </div>
            <div class="RecentContent">
                {{shortContent}}
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostRecent",
    data() {
      return {
        posterInfo:'',
        shortContent: this.recentInfo.postContent.substr(0, 35) + "......",
      }
    },
    props: {
      recentInfo: {
        required: true
      },
    },
    methods:{
      errHandler() {
        console.log(this.avatarUrl)
      }
    },
    created(){
      this.axios.get('http://47.107.77.163:8080/demo/getUserInfo',
        {
          params: {
            userId: sessionStorage.getItem('ID'),
          }
        }
      )
        .then((response) => {
          this.posterInfo = response.data.userInfo.user;
          // console.log(response)
          // console.log(this.posterInfo)
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    p {
        font-size: 12px;
    }

    .RecentPost {
        margin: 7px auto;
        .setMaxSize(250px, 80px);
        .setMinSize(250px,75px);
        .setBorder();
        box-shadow: 0 0 3px #2c2d2c;
        display: flex;
        justify-content: left;
    }

    .RecentContent {
        .setMaxSize(179px, 47px);
        .setMinSize(179px,23px);
        margin-top: 20px;
        margin-bottom: 5px;
        margin-right: 5px;
        border-radius: 5px;
        padding: 8px;
        font-size: 12px;
        background-color: #f3f3f3;
    }
</style>