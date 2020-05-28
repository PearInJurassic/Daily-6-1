<template>
    <div class="PostContent">
        <div class="Content">
            <div @click="openDetail" class="PictureContent">
                <el-image :src="itemInfo.postImg" alt="帖子图片"
                          fit="cover"
                          style="width:650px; ">
                </el-image>
            </div>
            <div class="PostInfo" style="display: flex;justify-content: space-between">
                <div style="display: flex">
                    <div @click="gotoPerson(posterInfo.userId)" class="Avatar" v-if="!itemInfo.anonym">
                        <el-avatar :size="68" :src="posterInfo.userImg"></el-avatar>
                    </div>
                    <div class="Avatar" v-if="itemInfo.anonym">
                        <el-avatar :size="68" :src="anonymousAvatar"></el-avatar>
                    </div>
                    <div class="Icon userName" style="width: 50px" v-if="!itemInfo.anonym">
                        {{posterInfo.userName}}
                    </div>
                    <div class="Icon userName" style="width: 50px" v-if="itemInfo.anonym">
                    </div>
                    <div class="Icon">
                        <button @click="pressLikeButton" class="IconButton" id="likeButton">
                            <img :src="likeUrl" alt="喜欢按钮">
                        </button>
                    </div>
                    <div class="Icon" v-if="itemInfo.userId != loginUserId">
                        <button @click="forwardpostButton" class="IconButton" id="ResendButton">
                            <img alt="转发按钮" src="@/assets/Post/resend.png">
                        </button>
                    </div>
                </div>
                <div class="Icon" id="delete" v-if="itemInfo.userId == loginUserId">
                    <button @click="pressDeleteButton" class="IconButton" id="DeleteButton">
                        <img alt="删除按钮" src="@/assets/Post/delete.png">
                    </button>
                </div>
            </div>
            <div>
                <p>{{itemInfo.postContent}}</p>
                <div class="forwardPost" v-if="itemInfo.forwardPostId != -1">
                    <div class="forwardContent">
                        1110
                    </div>
                    <el-button @click="originDetail(itemInfo.forwardPostId)" type="text">点击查看原贴</el-button>
                </div>
            </div>
        </div>
        <PostDetail :isLike="like"
                    :itemInfo="aimInfo.aimPostInfo"
                    :pInfo="aimInfo.aimPosterInfo"
                    @childAddLike="like = 1"
                    @childRemoveLike="like = 0"
                    @detailState="changeDetailState"
                    v-if="detailShowState">
        </PostDetail>
    </div>
</template>

<script>
  import PostDetail from "@/pages/PostPage/components/Post/PostDetail";

  export default {
    inject: ['reload'],
    name: "PostAll",
    data() {
      return {
        aimInfo: {
          aimPostInfo: this.itemInfo,
          aimPosterInfo: {}
        },
        loginUserId: 0,
        like: this.likeInfo,
        likeImgArr: ['like.png', 'like-fill.png', 'like-fill.png', 'like-fill.png'],
        detailShowState: false,
        posterInfo: {}
      }
    },
    props: {
      itemInfo: {
        required: true,
      },
      likeInfo: {
        required: true,
      }
    },
    computed: {
      anonymousAvatar() {
        return this.ANONYMOUS_AVATAR;
      },
      likeUrl() {
        return require(`@/assets/Post/${this.likeImgArr[this.like]}`);
      }
    },
    methods: {
      /**
       * @Descripsion 传递点赞按钮事件的函数
       */
      pressLikeButton() {
        this.like > 0 ? this.like = 0 : this.like = 1;
        let that = this;
        if (this.like == 1) {
          this.axios.post(`${this.GLOBAL.apiUrl}/addlike`, {
            userId: sessionStorage.getItem("ID"),
            postId: that.itemInfo.postId,
          })
        } else {
          this.axios.get(`${this.GLOBAL.apiUrl}/removelike`, {
            params: {
              userId: sessionStorage.getItem("ID"),
              postId: that.itemInfo.postId,
            }
          }).then((response) => {
            console.log(response)
          })
        }
      },
      /**
       * @description 点击删除按钮
       */
      pressDeleteButton() {
        this.axios.get(`${this.GLOBAL.apiUrl}/removepost`, {
          params: {
            postId: this.itemInfo.postId
          }
        }).then((response) => {
          this.$emit("deleteSuccess")
          if (response.data.success) {
            this.$message({
              message: "删除成功",
              type: "success",
            })
          }
        })
      },
      /**
       * @description 点击转发按钮
       */
      forwardpostButton() {
        this.axios.get(`${this.GLOBAL.apiUrl}/forwardpost`, {
          params: {
            postId: this.itemInfo.postId,
            userId: sessionStorage.getItem("ID"),
            str: "快速转发"
          }
        }).then(() => {
          this.reload();
          // console.log(response)
        })
      },
      /**
       * @description 传递帖子详情界面的状态
       */
      changeDetailState(state) {
        this.detailShowState = state;
      },
      /**
       * @description 打开详情的弹层
       */
      openDetail() {
        this.aimInfo.aimPostInfo = this.itemInfo;
        this.aimInfo.aimPosterInfo = this.posterInfo;
        this.detailShowState = true;
      },
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
       * @description 查看原帖详情
       */
      originDetail(forwardPostId) {
        this.axios.get(`${this.GLOBAL.apiUrl}/getpostbypostid`, {
          params: {
            postId: forwardPostId,
          }
        }).then((response) => {
          // console.log(response);
          this.aimInfo.aimPostInfo = response.data.post
          this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`, {
            params: {
              userId: response.data.post.userId
            }
          }).then((response)=>{
            console.log(response)
            this.aimInfo.aimPosterInfo = response.data.userInfo.user
          })
          this.detailShowState = true;
        })
        console.log(this.aimInfo.aimPosterInfo.userId);
      }
    },
    components: {
      PostDetail
    },
    created() {
      this.loginUserId = sessionStorage.getItem("ID")
      let posterID = this.itemInfo.userId
      // 请求后端数据,查询数据源
      this.axios.get('http://47.107.77.163:8080/demo/getUserInfo',
        {
          params: {
            userId: posterID
          }
        }
      )
        .then((response) => {
          this.posterInfo = response.data.userInfo.user;
          this.aimInfo.aimPosterInfo= response.data.userInfo.user;
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
        padding: 5px 10px;
    }

    #delete {
        margin-right: 20px;
    }

    .userName {
        font-size: 15px;
        padding-bottom: 10px;
    }

    .PostContent {
        max-width: 650px;
        margin-bottom: 60px;
        .setBorder();
        background-color: whitesmoke;
    }

    .Content :hover {
        cursor: pointer;
    }

    .PictureContent {
        max-height: 800px;
        max-width: 650px;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }
</style>