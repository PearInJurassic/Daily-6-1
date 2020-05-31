<template>
    <div>
        <div class="CommentContent">
            <div class="Comment">
                <div class="Avatar">
                    <el-avatar :src="user.userImg"></el-avatar>
                </div>
                <div class="CommentText">
                    <p>{{shortText}}</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostCommentAll",
    data() {
      return {
        user:{
          userName:'',
          userImg:''
        }
      }
    },
    props: {
      headComment: {
        required: true
      }
    },
    computed: {
      shortText() {
        if (this.headComment.commentContent.length > 45)
          return this.headComment.commentContent.slice(0, 45) + "..."
        else return this.headComment.commentContent
      }
    },
    created() {
      let userId=this.headComment.userId;
        // console.log(this.headComment.userId)
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`,{
        params:{
          userId
        }
      }).then((response) => {
        this.user.userName = response.data.userInfo.user.userName;
        this.user.userImg = response.data.userInfo.user.userImg;
      })
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";
    p {
        word-wrap: break-word;
        word-break: break-all;
    }
    .Comment {
        display: flex;
        justify-content: left;
        .setMaxSize(280px,70px)
    }
    .CommentText {
        width: calc(100% - 50px);
    }
    .reply {
        padding-right: 20px;
    }
</style>

