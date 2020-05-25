<template>
    <div>
        <PostDetail :itemInfo="recentInfo"
                    :isLike="1"
                    :pInfo="posterInfo"
                    @detailState="changeDetailState"
                    v-if="detailShowState">
        </PostDetail>
        <div class="RecentPost" @click="detailPost()">
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
    import PostDetail from "@/pages/PostPage/components/Post/PostDetail";
  export default {
    name: "PostRecent",
    data() {
      return {
        detailShowState:false,
        posterInfo:'',
        shortContent: this.recentInfo.postContent.substr(0, 35) + "......",
      }
    },
    props: {
      recentInfo: {
        required: true
      },
    },
    components:{
      PostDetail
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