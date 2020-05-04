<template>
    <div class="ContentAll">
        <div class="ContentCenter">
            <PostAll :imgUrl="img"></PostAll>
            <component :is="PostAll"
                       :key="index"
                       v-for="(index) in postNum">
            </component>
        </div>
    </div>
</template>

<script>
  import PostAll from "@/pages/PostPage/components/Post/PostAll";
  import Bus from "@/JS/bus.js";

  export default {
    name: "ContentPostMain",
    data() {
      return {
        PostAll: "PostAll",
        postNum: [],
        img:"",
      }
    },
    components: {
      PostAll,
    },
    methods: {
      /**
       * @description 初始化渲染帖子列表。
       */
      init() {
        this.axios({
          method: "get",
          url: "data/index"
        })
          .then((response) => {
            console.log(response)
            this.img="@/assets/plumeria.jpg"
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    created() {
        this.init();
    },
    mounted() {
      Bus.$on("finishEdit", () => {
        //TODO 将帖子的id压入而非压入1防止错误。
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

        padding-top: 30px;
    }
</style>