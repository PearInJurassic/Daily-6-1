<template>
    <div class="ContentAll">
        <div class="PosterInfo">
            <div class="Avatar">
                <el-avatar :src="headUrl" :size="42"></el-avatar>
                <button class="IconButton" id="followButton">
                    <img :src="followUrl" alt="关注按钮">
                </button>
            </div>
            <div class="Icon">
                <button class="IconButton" id="reportButton">
                    <img :src="reportUrl" @click="reportPost" alt="举报按钮">
                </button>
            </div>
        </div>
        <div class="Comment">
            <component :is="PostCommentAll"
                       :key="index"
                       :text="item[0].commentContent"
                       v-for="(item,index) in commentNum">
            </component>
            <div style="width:280px;height:30px;background-color: #3a8ee6"></div>
        </div>
        <div class="IconGroup" style="display: flex">
            <div class="Icon">
                <button @click="pressLikeButton" class="IconButton" id="likeButton">
                    <img :src="likeUrl" alt="喜欢按钮">
                </button>
            </div>
            <div class="Icon">
                <button class="IconButton" id="ResendButton">
                    <img alt="转发按钮" src="@/assets/Post/resend.png">
                </button>
            </div>
        </div>
        <div class="CommentAdder">
            <el-input
                    :row="2"
                    placehoder="请输入评论"
                    type="textarea"
                    v-model="commentText">
            </el-input>
            <button @click="addComment" class="CommonButton">发布</button>
        </div>
    </div>
</template>

<script>
  import PostCommentAll from "@/pages/PostPage/components/Post/PostCommentAll";

  export default {
    name: "PanelComment",
    data() {
      return {
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        reportUrl: require("@/assets/Post/report.png"),
        like: this.isLike,
        likeImgArr: ['like.png', 'like-fill.png'],
        commentNum: [],
        commentText: '1234',
        PostCommentAll: "PostCommentAll",
        followUrl:require("@/assets/Post/关注.png")
      }
    },
    props:{
      isLike:{
        required:true
      },
      item:{
        required:true
      }
    },
    computed: {
      likeUrl() {
        return require(`@/assets/Post/${this.likeImgArr[this.like]}`);
      }
    },
    components: {
      PostCommentAll
    },
    methods: {
      /**
       * @description 传递点赞按钮事件的函数
       */
      pressLikeButton() {
        this.like ? this.like = 0 : this.like = 1;
        let that = this;
        if (this.like === 1) {
          this.axios.post(`${this.GLOBAL.apiUrl}/addlike`, {
            userId: sessionStorage.getItem("ID"),
            postId: that.item.postId,
          })
            .then(() => {
              this.$emit("childAddLike")
            })
        } else {
          this.axios.get(`${this.GLOBAL.apiUrl}/removelike`, {
            params: {
              userId: sessionStorage.getItem("ID"),
              postId: that.item.postId,
            }
          })
            .then(() => {
              this.$emit("childRemoveLike")
            })
        }
      },
      /**
       * @description 发布评论
       */
      addComment() {
        this.axios.post(`${this.GLOBAL.apiUrl}/comment/createcomment`,{
            "commentContent": this.commentText,
            "postId": this.item.postId,
            "userId": sessionStorage.getItem("ID"),
            "anonym": 0,
            "replyCommentId": 0
        })
        .then((response)=>{
          console.log(response)
        })
        this.commentNum.push(this.commentText);
        this.commentText = ''
      },
      /**
       * @description 举报帖子
       */
      reportPost() {
        this.$confirm('你确定要举报此贴吗?', '举报', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
          .then(() => {
            this.axios.get(`${this.GLOBAL.apiUrl}/tipoffpost`,{
              params:{
                postId:this.item.postId,
              }
            })
            .then((response) =>{
              console.log(response)
            })
            this.$message({
              type: 'success',
              message: '举报成功！'
            });
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消举报操作'
            })
          })
      }
    },
    created() {
      this.axios.get(`${this.GLOBAL.apiUrl}/comment/getcommentbypostid`,{
        params:{
          postId:this.item.postId
        }
      }).then((response) => {
        let commentList = response.data.commentList;
        for (let index in commentList) {
          this.commentNum.push(commentList[index])
          console.log(commentList[index],index)
        }
         console.log(response)
      })
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .PosterInfo {
        display: flex;
        justify-content: space-between;
    }
    .Icon {
        background-color: white;
    }
    .IconButton {
        background-color: white;
    }
    .Comment {
        margin: 2px auto;
        display: flex;
        .setSize(280px, 400px);
        .setBorder();
        flex-direction: column;
        justify-content: flex-start;
        overflow: auto;
    }

    .ContentAll {
        display: flex;
        justify-content: space-between;
        flex-direction: column;
    }

    .CommentAdder {
        display: flex;
        justify-content: center;
        flex-direction: column;
        .setSize(280px, 100px);
        margin: 2px auto 10px auto;
    }

    .CommentEditor {
        .setSize(100%, 100%);
        .setBorder();
        background-color: white;
        margin: 2px 0 -30px 0;
    }

</style>