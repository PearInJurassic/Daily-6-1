<template>
    <div class="ContentAll">
        <div class="PosterInfo">
            <div class="Avatar">
                <div @click="gotoPerson(postInfo.userId)" class="avatar" v-if="!item.anonym">
                    <el-avatar :size="42" :src="postInfo.userImg"></el-avatar>
                </div>
                <div @click="gotoPerson(postInfo.userId)" class="avatar" v-if="item.anonym">
                    <el-avatar :size="42" :src="anonymousAvatar"></el-avatar>
                </div>
                <el-tooltip class="item" content="关注用户" effect="dark" placement="right" v-if="!item.anonym">
                    <button class="IconButton" id="followButton">
                        <img :src="followUrl" @click="follow" alt="关注按钮">
                    </button>
                </el-tooltip>
            </div>
            <div class="Icon">
                <el-tooltip class="item" content="举报该帖" effect="dark" placement="left">
                    <button class="IconButton" id="reportButton">
                        <img :src="reportUrl" @click="reportPost" alt="举报按钮">
                    </button>
                </el-tooltip>
            </div>
        </div>
        <div class="Comment">
            <p v-if="commentList.length==0">暂无评论，我来发表第一篇评论！</p>
            <el-collapse @change="change" accordion v-model="activeName">
                <el-collapse-item :key="index"
                                  :name="item[0].commentId"
                                  v-for="(item,index) in commentList">
                    <template slot="title">
                        <div class="CommentPanel">
                            <PostCommentAll :headComment="item[0]"></PostCommentAll>
                        </div>
                    </template>
                    <PostCommentChild :headComment="item[index]"
                                      :key="index" v-for="(i,index) in item">
                    </PostCommentChild>
                </el-collapse-item>
            </el-collapse>
            <div style="width:280px;height:30px;background-color: #3c3d3e"></div>
        </div>
        <div class="IconGroup" style="display: flex">
            <div class="Icon">
                <button @click="pressLikeButton" class="IconButton" id="likeButton">
                    <img :src="likeUrl" alt="喜欢按钮">
                </button>
            </div>
            <div class="LikeNum Icon">
                {{likeNums}}
            </div>
            <div class="Icon">
                <button class="IconButton" id="ResendButton">
                    <img alt="转发按钮" src="@/assets/Post/resend.png">
                </button>
            </div>
        </div>
        <div class="CommentAdder">
            <el-input
                    maxlength="130"
                    placehoder="请输入评论"
                    show-word-limit
                    type="textarea"
                    v-model="commentText">
            </el-input>
            <button @click="addComment" class="CommonButton">发布</button>
        </div>
    </div>
</template>

<script>
  import PostCommentAll from "@/pages/PostPage/components/Post/PostCommentAll";
  import PostCommentChild from "@/pages/PostPage/components/Post/PostCommentChild";

  export default {
    name: "PanelComment",
    data() {
      return {
        postIdReplyTo:-1,
        posterNameReplyTo:"",
        activeName: 1,
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        reportUrl: require("@/assets/Post/report.png"),
        like: this.isLike,
        likeNums: 0,
        likeImgArr: ['like.png', 'like-fill.png'],
        commentList: [],
        commentText: '',
        PostCommentAll: "PostCommentAll",
        followUrl: require("@/assets/Post/follow.png"),
      }
    },
    props: {
      isLike: {
        required: true
      },
      item: {
        required: true
      },
      postInfo: {
        required: true
      }
    },
    computed: {
      likeUrl() {
        return require(`@/assets/Post/${this.likeImgArr[this.like]}`);
      },
      anonymousAvatar() {
        return this.ANONYMOUS_AVATAR;
      }
    },
    components: {
      PostCommentAll,
      PostCommentChild
    },
    methods: {
      /**
       * @description 跳转到个人空间
       */
      gotoPerson(otherId) {
        if (otherId == sessionStorage.getItem('ID')) {
          this.$router.push('/personpage')
        } else {
          this.$router.push(`/others/${otherId}`)
        }
      },
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
              this.likeNums++;
            })
        } else {
          this.axios.get(`${this.GLOBAL.apiUrl}/removelike`, {
            params: {
              userId: sessionStorage.getItem("ID"),
              postId: that.item.postId,
            }
          })
            .then(() => {
              this.likeNums--;
              this.$emit("childRemoveLike")
            })
        }
      },
      /**
       * @description 发布评论
       */
      addComment() {
        let replyCommentId = (this.postIdReplyTo == -1) ? 0 : this.postIdReplyTo;
        let anonym=this.$store.state.isAnonymous;
        this.axios.post(`${this.GLOBAL.apiUrl}/comment/createcomment`, {
          "commentContent": this.commentText,
          "postId": this.item.postId,
          "userId": sessionStorage.getItem("ID"),
          anonym,
          replyCommentId
        })
          .then((response) => {
            console.log(this.commentList)
            let newCommentChildList = [];
            newCommentChildList.push(response.data.newComment)
            if (!replyCommentId) {//如果是顶层回复
              this.commentList.push(newCommentChildList);
            } else {//如果是评论的回复
                for(let index in this.commentList) {
                  if(this.commentList[index][0].commentId == replyCommentId) {
                    this.commentList[index].push(response.data.newComment)
                  }
                }
            }
            console.log(this.commentList)
          })
        // this.commentNum.push(this.commentText);
        this.commentText = ''
      },
      /**
       * @description 删除评论
       */
      // deleteFromList(commentId){
      //   for(let index in this.commentList) {
      //     if(this.commentList[index][0].commentId == commentId) {
      //       this.commentList.splice(index,1);
      //     }
      //   }
      // },
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
            this.axios.get(`${this.GLOBAL.apiUrl}/tipoffpost`, {
              params: {
                postId: this.item.postId,
              }
            })
              .then(() => {
                this.$message({
                  type: 'success',
                  message: '举报成功！'
                });
                // console.log(response)
              })
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消举报操作'
            })
          })
      },
      /**
       * @description 关注用户
       */
      follow() {
        this.axios.get(`${this.GLOBAL.apiUrl}/addFollow`, {
          params: {
            userId: sessionStorage.getItem('ID'),
            followId: this.postInfo.userId,
          }
        }).then(() => {
          this.$message({
            type: 'success',
            message: '关注成功！'
          });
        })
      },
      /**
       * @description 获取评论列表
       */
      getComments() {
        this.axios.get(`${this.GLOBAL.apiUrl}/comment/getcommentbypostid`, {
          params: {
            postId: this.item.postId
          }
        }).then((response) => {
          // console.log(response)
          let commentList = response.data.commentList;
          for (let index in commentList) {
            this.commentList.push(commentList[index])
          }
        })
      },
      /**
       * @description 获取点赞数
       */
      getLikeNums() {
        this.axios.get(`${this.GLOBAL.apiUrl}/getlikenum`, {
          params: {
            postId: this.item.postId
          }
        }).then((response) => {
          this.likeNums = response.data.likeNum;
        })
      },
      /**
       * @description 点击某栏后的操作
       * @param activeNum 点击某栏后获得的栏号，此处是评论的id
       */
      change(activeNum) {
        this.axios.get(`${this.GLOBAL.apiUrl}/comment/getcommentbycommentid`, {
          params: {
            commentId:activeNum
          }
        }).then((response)=>{
          let userId=response.data.comment.userId;
          this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`, {
            params: {
              userId
            }
          }).then((r)=>{
            this.commentText = `"@${r.data.userInfo.user.userName}":`
          })
        })
        this.postIdReplyTo = activeNum;
      }
    },
    created() {
      //获取评论列表。
      this.getComments();
      this.getLikeNums();
    },

  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    p {
        margin: 15px auto;
    }

    .PosterInfo {
        display: flex;
        justify-content: space-between;
    }

    .LikeNum {
        color: #7f7f7f;
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

    .CommentPanel {
        width: 100%;
    }

    .Avatar {
        display: flex;

        .avatar:hover {
            cursor: pointer;
        }
    }

</style>

<style lang="less">
    .Comment {
        .el-collapse-item__header {
            display: flex;
            min-height: 65px;
            max-height: 105px;
            line-height: 15px;
            background-color: whitesmoke;
        }
        .el-collapse-item__wrap {
            background-color: #eeeeee;
        }
    }


</style>