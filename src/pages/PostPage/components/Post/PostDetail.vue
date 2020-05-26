<template>
    <div class="contentDetail" v-if="isShow">
        <div @click="closeDetail" class="Mask"></div>
        <div class="PostDetail">
            <div class="PictureDetail">
                <div>
                    <el-image :preview-src-list="srcList"
                              :src="url">
                    </el-image>
                </div>
                <el-carousel height="400px">
                    <el-carousel-item :key="item" v-for="item in 4">
                        <el-image :src="itemInfo.postImg"
                                  alt="图片"
                                  fit="cover"
                        >
                        </el-image>
                    </el-carousel-item>
                </el-carousel>
                <PanelTag :item="itemInfo"></PanelTag>
                <div class="Paragraph">
                    <p>{{itemInfo.postContent}}</p>
                </div>
            </div>
            <div class="CommentDetail" v-if="visible">
                <PanelComment :isLike="isLike"
                              :item="itemInfo"
                              :postInfo="pInfo"
                              @childAddLike="childAddLike"
                              @childRemoveLike="childRemoveLike">
                </PanelComment>
            </div>
        </div>
    </div>
</template>

<script>
  import PanelTag from "@/pages/PostPage/components/Panel/PanelTag";
  import PanelComment from "@/pages/PostPage/components/Panel/PanelComment";

  export default {
    name: "PanelPostDetail",
    data() {
      return {
        windowWidth: document.documentElement.clientWidth,
        isShow: true,
        srcList: [
          // 'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
          // 'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
        ],
        url: require("@/assets/Post/pictureDetail.png"),
      }
    },
    props: {
      itemInfo: {
        required: true
      },
      isLike: {
        required: true
      },
      pInfo: {
        required: true
      }
    },
    computed:{
      visible(){
        if(this.windowWidth<950){
          return false;
        }
        return true;
      }
    },
    components: {
      PanelComment,
      PanelTag
    },
    methods: {
      /**
       * @description 点击蒙版关闭详情
       */
      closeDetail() {
        this.isShow = false;
        this.$emit("detailState", this.isShow);
      },
      childAddLike() {
        this.$emit("childAddLike");
      },
      childRemoveLike() {
        this.$emit('childRemoveLike')
      }
    },
    created() {
      this.srcList.push(this.itemInfo.postImg)
      // console.log(this.pInfo)
    },
    watch: {
      '$store.state.screenWidth': function (val) { //监听屏幕宽度变化
        this.windowWidth = val;
      }
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    p {
        font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
    }

    .contentDetail {
        display: flex;
        max-width: 1800px;
    }

    .PostDetail {
        max-width: 1800px;
        max-height: 600px;
        border: 0 solid black;
        border-radius: 4px;
        box-shadow: 0 0 2px black;
        background-color: white;
        display: flex;
        position: fixed;
        top: calc(50% - 300px);
        left: auto;
        z-index: 15;
    }

    .PictureDetail {
        display: flex;
        .setBorder();
        .setMinSize(600px, 600px);
        justify-content: center;
        flex-direction: column;
    }

    .CommentDetail {
        display: flex;
        .setBorder();
        .setSize(300px, 600px);
        justify-content: center;
    }

    .Paragraph {
        .setMaxSize(100%, 120px);
        margin: 12px 5px;
    }

    .el-carousel__item {
        display: flex;
        justify-content: center;
    }

    .el-carousel__item:nth-child(2n) {
        height: 100%;
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        height: 100%;
        background-color: #d3dce6;
    }
</style>
