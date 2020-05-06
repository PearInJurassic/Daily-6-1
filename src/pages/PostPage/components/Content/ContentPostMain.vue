<template>
    <div class="ContentAll">
        <div class="ContentCenter">
<!--            <PostAll :imgUrl="img" :itemInfo="postNum[0]"></PostAll>-->
            <component :is="PostAll"
                       :key="item.id"
                       :itemInfo="postNum[index]"
                       v-for="(item,index) in postNum">
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
        let url=location.search;//获取url
        let userID = url.split('=')[1];
        sessionStorage.setItem('ID',userID);
        this.axios({
          method: "get",
          url: "data/index"
        })
          .then((response) => {
            console.log(response)
            let postData = response.data.postItem;
            for(let item in postData) {
              console.log(postData[item]);
              this.postNum.push(postData[item])
            }
            console.log(this.postNum)
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