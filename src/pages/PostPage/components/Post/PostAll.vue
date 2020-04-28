<template>
    <div class="PostContent">
        <div class="Content"
             @click="openDetail">
        <div class="PictureContent"></div>
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
                    <img src="@/assets/Post/resend.png" alt="转发按钮">
                </button>
            </div>
        </div>
        </div>
        <PostDetail @detailState="changeDetailState"
                    v-if="detailShowState"></PostDetail>
    </div>
</template>

<script>
  import PostDetail from "@/pages/PostPage/components/Post/PostDetail";

  export default {
    name: "PostAll",
    data() {
      return {
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        like: 0,
        likeImgArr: ['like.png', 'like-fill.png'],
        detailShowState: false,
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
      }
    },
    components: {
      PostDetail
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .PostContent {
        .setSize(650px, 900px);
        margin-bottom: 60px;
        min-height: 900px;
        .setBorder();
    }
    .Content :hover {
        cursor:pointer;
    }

    .PictureContent {
        .setSize(650px, 750px);
        .setBorder();
    }
</style>