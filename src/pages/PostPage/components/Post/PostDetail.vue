<template>
    <div v-if="isShow">
        <div @click="closeDetail" class="Mask"></div>
        <div class="PostDetail">
            <div class="PictureDetail"></div>
            <div class="CommentDetail"></div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PanelPostDetail",
    data() {
      return {
        isShow: true,
      }
    },
    methods: {
      closeDetail() {
        this.isShow = false;
        this.$emit("detailState",this.isShow);
      },
      bodyScroll(event) {
        event.preventDefault();
      }
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
        .setSize(600px, 400px);
        border: 0 solid black;
        border-radius: 4px;
        box-shadow: 0 0 2px black;
        background-color: white;
        display: flex;
        position: fixed;
        top: calc(50% - 300px);
        left: calc(50% - 200px);
        z-index: 15;
    }

    .PictureDetail {
        .setBorder();
        .setSize(400px,400px);
    }
</style>