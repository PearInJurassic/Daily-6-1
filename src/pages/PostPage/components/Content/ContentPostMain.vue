<template>
    <div class="ContentAll">
        <div class="ContentCenter" v-loading="loading">
            <component :is="PostAll"
                       :key="index"
                       :itemInfo="postNum[index]"
                       :likeInfo ="likeList[index]"
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
        likeList:[],
        loading:true
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
        // let url=location.search;//获取url
        // let userID = url.split('=')[1];
        // sessionStorage.setItem('ID',userID);
        let userID = sessionStorage.getItem("ID");
        this.axios.get(`${this.GLOBAL.apiUrl}/listpost`,{
          params:{
            userId:userID,
          }
        })
          .then((response) => {
            this.loading=false
            this.likeList = [...response.data.likeList];
            // console.log(this.likeList)
            let postData = response.data.postList;
            for(let index in postData) {
              this.postNum.push(postData[index])
            }
            // console.log(this.postNum)
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
        console.log('success')
      });
      Bus.$on("finishSearch",(list) =>{
        this.postNum=[];
        for(let index in list) {
          this.postNum.push(list[index])
        }
        this.loading=false;
      })
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