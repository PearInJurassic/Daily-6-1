<template>
    <div class="ContentAll">
        <div class="PosterInfo">
            <div class="Avatar">
                <el-avatar :src="headUrl" size="medium"></el-avatar>
            </div>
            <div class="Icon">
                <button class="IconButton" id="reportButton">
                    <img :src="reportUrl" alt="举报按钮">
                </button>
            </div>
        </div>
        <div class="Comment">
            <PostCommentAll></PostCommentAll>
            <component :is="PostCommentAll"
                       :key="index"
                       v-for="(index) in commentNum">
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
            <div class="CommentEditor"></div>
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
        like: 0,
        likeImgArr: ['like.png', 'like-fill.png'],
        commentNum: [],
        PostCommentAll: "PostCommentAll"
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
       * @Descripsion 传递点赞按钮事件的函数
       */
      pressLikeButton() {
        this.like ? this.like = 0 : this.like = 1;
      },
      /**
       * @description 发布评论
       */
      addComment() {
        //TODO 将评论的Id压入，而非1，防止错误。
        this.commentNum.push(1);
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .PosterInfo {
        display: flex;
        justify-content: space-between;
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