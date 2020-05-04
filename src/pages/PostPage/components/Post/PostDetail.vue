<template>
    <div v-if="isShow">
        <div @click="closeDetail" class="Mask"></div>
        <div class="PostDetail">
            <div class="PictureDetail">
                <div>
                    <el-image :src="url"
                              :preview-src-list="srcList"></el-image>
                </div>
                <el-carousel height="300px">
                    <el-carousel-item :key="item" v-for="item in 4">
                        <el-image src="https://interactive-examples.mdn.mozilla.net/media/examples/plumeria.jpg"
                                  alt="图片"
                                  :fit="scale-down"
                        style="height:300px;">
                        </el-image>
                    </el-carousel-item>
                </el-carousel>
                <PanelTag></PanelTag>
                <div class="Paragraph">
                    <p>555555555555555555</p>
                </div>
            </div>
            <div class="CommentDetail">
                <PanelComment></PanelComment>
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
        isShow: true,
        srcList:[
          'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
          'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
        ],
        url:require("@/assets/Post/放大镜.png"),
      }
    },
    props: {
      img: String,
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
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .PostDetail {
        height: 600px;
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
        .setSize(600px, 600px);
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
        .setBorder();
        .setSize(100%, 120px);
        margin: 12px 0;
    }
    .el-carousel__item {
        display: flex;
        justify-content: center;
    }
    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>
