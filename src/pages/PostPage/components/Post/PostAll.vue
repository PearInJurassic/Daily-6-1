<template>
    <div class="PostContent">
        <div class="Content">
            <div @click="openDetail" class="PictureContent">
                <el-image alt="帖子图片" fit="cover"
                          :src="itemInfo.postImg"
                          style="width:650px; ">
                </el-image>
            </div>
            <div class="PostInfo" style="display: flex">
                <div class="Avatar">
                    <el-avatar :size="68" :src="headUrl"></el-avatar>
                </div>
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
            <div>
                <p>{{itemInfo.postContent}}</p>
                <slot>
                </slot>
            </div>
        </div>
        <PostDetail :itemInfo="itemInfo"
                    :isLike="like"
                    @detailState="changeDetailState"
                    @childAddLike="like = 1"
                    @childRemoveLike="like = 0"
                    v-if="detailShowState">
        </PostDetail>
    </div>
</template>

<script>
  import PostDetail from "@/pages/PostPage/components/Post/PostDetail";

  export default {
    name: "PostAll",
    data() {
      return {
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        like: this.likeInfo,
        likeImgArr: ['like.png', 'like-fill.png'],
        detailShowState: false,
      }
    },
    props: {
      itemInfo: {
        required: true,
      },
      likeInfo: {
        type:Number,
        required: true,
      }
    },
    computed: {
      likeUrl() {
        return require(`@/assets/Post/${this.likeImgArr[this.like]}`);
      }
    },
    methods: {
      /**
       * @Descripsion 传递点赞按钮事件的函数
       */
      pressLikeButton() {
        this.like ? this.like = 0 : this.like = 1;
        let that = this;
        if (this.like === 1) {
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
          })
        }
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
        this.detailShowState = true;
      },
    },
    components: {
      PostDetail
    },
    created() {
      console.log(this.itemInfo)
      // console.log("success")
      // console.log(this.likeInfo)
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .PostContent {
        width: 650px;
        margin-bottom: 60px;
        .setBorder();
        background-color: whitesmoke;
    }

    .Content :hover {
        cursor: pointer;
    }

    .PictureContent {
        width: 650px;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }
</style>