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
        display: flex;
        justify-content: left;
    }

    .RecentContent {
        .setMaxSize(186px, 47px);
        .setMinSize(186px,30px);
        margin-top: 20px;
        .setBorder();
        padding: 4px;
        font-size: 12px;
    }
</style>