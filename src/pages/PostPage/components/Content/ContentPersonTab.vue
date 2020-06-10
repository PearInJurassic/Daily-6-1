<template>
    <div>
        <div :class="tabClass">
            <PostDetail :isLike="1"
                        :itemInfo="selectPostItem"
                        :pInfo="selectPosterInfo"
                        @detailState="detailShowState=false"
                        v-if="detailShowState">
            </PostDetail>
            <el-tabs v-model="activeName">
                <el-tab-pane label="帖子" name="first">
                    <div class="ItemContent">
                        <div class="tip" v-if="isPostListNull">
                            <img :src="tipUrl" width="975px">
                        </div>
                        <PersonItems :key="index"
                                     :postItem="userPostList[index]"
                                     v-for="(item,index) in userPostList">
                            <template>
                                <el-image :src="userPostList[index].postImg" @click="postDetail(userPostList[index])"
                                          fit="cover"
                                          style="width: 100%;height: 100%">
                                </el-image>
                            </template>
                        </PersonItems>
                    </div>
                </el-tab-pane>
                <slot name="record">
                    <el-tab-pane label="动态" name="second">
                        <div class="tip" v-if="isRecordListNull">
                            <img :src="tipUrl" width="975px">
                        </div>
                        <div class="ItemContent">
                            <PersonItems :key="index"
                                         :recordItem="userRecordList[index]"
                                         v-for="(item,index) in userRecordList">
                                <el-image :src="userRecordList[index].record.recordImg" fit="cover"
                                          style="width: 100%;height: 100%">
                                </el-image>
                            </PersonItems>
                        </div>
                    </el-tab-pane>
                </slot>
            </el-tabs>
        </div>
    </div>
</template>

<script>
  import PersonItems from "@/pages/PostPage/components/Person/PersonItems";
  import PostDetail from "@/pages/PostPage/components/Post/PostDetail";

  export default {
    name: "ContentPersonTab",
    data() {
      return {
        windowWidth: document.documentElement.clientWidth,
        userInfo: {},
        selectPostItem: {},
        selectPosterInfo: {},
        detailShowState: false,
        tipUrl: require("@/assets/Person/tip.png"),
        activeName: 'first',
        isPostListNull: true,
        isRecordListNull: true,
        userPostList: [],
        userRecordList: []
      }
    },
    computed: {
      tabClass() {
        if (this.windowWidth > 500) {
          return "TabContent"
        } else {
          return "mobile_person_tab"
        }
      }
    },
    props: {
      isOthers: {}
    },
    components: {
      PersonItems,
      PostDetail
    },
    methods: {
      postDetail(selectItem) {
        this.detailShowState = true;
        this.selectPostItem = selectItem;
      },
    },
    created() {
      //当前个人主页的用户id
      let userId = this.isOthers
        ?
        sessionStorage.getItem('viewId')
        :
        sessionStorage.getItem('ID')
      this.axios.get(`${this.GLOBAL.apiUrl}/userPostAndRecordList`, {
        params: {
          userId
        }
      })
        .then((response) => {
          let postList = response.data.userPostList
          let recordList = response.data.userRecordList
          console.log(response)
          for (let index in postList) {
            this.userPostList.push(postList[index])
          }
          for (let index in recordList) {
            this.userRecordList.push(recordList[index])
          }
          if (postList.length) this.isPostListNull = false;
          if (recordList.length) this.isRecordListNull = false;
          // console.log(this.userPostList)
        })
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`,
        {
          params: {
            userId
          }
        }
      ).then((response) => {
        this.selectPosterInfo = response.data.userInfo.user;
        console.log(response)
      })
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

    .tip {
        margin-top: 16%;
    }

    .TabContent {
        margin-top: 50px;
        .setSize(975px, 600px);
        flex-direction: row;
        justify-content: center;
    }

    .ItemContent {
        display: flex;
        flex-wrap: wrap;
    }

</style>

<style lang="less">
    .TabContent {
        .el-tabs__item {
            font-size: 20px;
            color: black;
            padding-right: 150px;
        }

        .el-tabs__active-bar {
            width: 32px;
            background-color: #7f7f7f;
        }

        .el-tabs__nav-scroll {
            display: flex;
            justify-content: center;
        }
    }
</style>