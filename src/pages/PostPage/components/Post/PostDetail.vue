<template>
    <div v-if="isShow">
        <div @click="closeDetail" class="Mask"></div>
        <div class="PostDetail">
            <div class="PictureDetail">
                <el-carousel height="300px">
                    <el-carousel-item :key="item" v-for="item in 4">
                        <h3 class="small">{{ item }}</h3>
                    </el-carousel-item>
                </el-carousel>
                <PanelTag></PanelTag>
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
    },
    create() {
      console.log('success');
      document.body.addEventListener('touchmove', this.bodyScroll, {passive: false});
    },
    destroyed() {
      document.body.removeEventListener('touchmove', this.bodyScroll, {passive: false});
    }
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


    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 150px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>