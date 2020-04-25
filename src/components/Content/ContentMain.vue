<template>
    <div class="ContentAll">
        <div class="ContentCenter">
            <PostAll></PostAll>
            <component :is="PostAll"
                       :key="index"
                       v-for="(index) in postNum"></component>
        </div>
    </div>
</template>

<script>
  import PostAll from "@/components/Post/PostAll";
  import Bus from "@/JS/bus.js";

  export default {
    name: "ContentMain",
    data() {
      return {
        PostAll:"PostAll",
        postNum: [],
      }
    },
    components: {
      PostAll,
    },
    mounted() {
      Bus.$on("finishEdit", () => {
        console.log("success");
        this.postNum.push(1);
      });
    }
  }
</script>

<style lang="less" scoped>
    @outlineColor: #989899;
    .ContentAll {
        display: flex;
        max-width: 1025px;
        min-width: 650px;
    }

    .ContentCenter {
        max-width: 1025px;
        min-width: 650px;
        border: 2px solid @outlineColor;
        padding-top: 30px;
    }
</style>