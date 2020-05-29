<template>
    <div class="ContentAll">
        <div class="ContentCenter" v-loading="loading">
            <div>
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleMenuSelect">
                    <el-menu-item index="1">按时间排序</el-menu-item>
                    <el-menu-item index="2">查看关注对象发帖</el-menu-item>
                </el-menu>
            </div>
            <component :is="PostAll"
                       :key="index"
                       :itemInfo="postNum[index]"
                       :likeInfo ="likeList[index]"
                       @deleteSuccess="reloadAfterDelete"
                       v-for="(item,index) in postNum">
            </component>
        </div>
    </div>
</template>

<script>
  import PostAll from "@/pages/PostPage/components/Post/PostAll";
  import Bus from "@/JS/bus.js";

  export default {
    inject: ['reload'],
    name: "ContentPostMain",
    data() {
      return {
        activeIndex:"1",
        windowWidth:document.documentElement.clientWidth,
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
       * @description 按照时间顺序展示帖子。
       */
      getPostListByTime(){
        let userID = sessionStorage.getItem("ID");
        this.axios.get(`${this.GLOBAL.apiUrl}/listpost`,{
          params:{
            userId:userID,
          }
        })
          .then((response) => {
            console.log(response)
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
      },
      /**
       * @description 初始化渲染帖子列表。
       */
      init() {
        // let url=location.search;//获取url
        // let userID = url.split('=')[1];
        // sessionStorage.setItem('ID',userID);
        this.getPostListByTime();
      },
      /**
       * @description 按照关注列表显示帖子
       */
      getPostListByFollow() {
        let userID = sessionStorage.getItem("ID");
        this.axios.get(`${this.GLOBAL.apiUrl}/userFollowPostList`,{
          params:{
            userId:userID,
          }
        })
          .then((response) => {
            console.log(response)
            this.loading=false
            this.likeList = [...response.data.likeList];
            // console.log(this.likeList)
            let postData = response.data.userFollowPostList;
            for(let index in postData) {
              this.postNum.push(postData[index])
            }
            // console.log(this.postNum)
          })
          .catch((error) => {
            console.log(error);
          });
      },

      /**
       * @description 刷新页面
       */
      reloadAfterDelete() {
        this.reload();
      },
      /**
       * @description 选择帖子展示方式
       */
      handleMenuSelect(key){
        switch (key) {
            case "1":
              this.getPostListByTime()
              break;
            case "2":
              this.getPostListByFollow();
              break;
        }
        console.log(key)
      }
    },
    created() {
        this.init();
    },
    mounted() {
      Bus.$on("finishEdit", (flag) => {
        switch (flag) {
            case 'finish':
              console.log("finish")
              this.reload();
              break;
            default:
              break;
        }
        // console.log('success')
      });
      Bus.$on("finishSearch",(list) =>{
        this.postNum=[];
        for(let index in list) {
          this.postNum.push(list[index])
        }
        this.loading=false;
      })
    },
    watch:{
      '$store.state.screenWidth':function(val){ //监听屏幕宽度变化
        this.windowWidth=val;
      }
    },
  }
</script>

<style lang="less" scoped>
    @outlineColor: #989899;
    .ContentAll {
        display: flex;
        max-width: 1025px;
        min-width: 350px;
    }

    .ContentCenter {
        max-width: 1025px;
        min-width: 350px;

        padding-top: 30px;
    }
</style>