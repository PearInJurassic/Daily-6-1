<template>
    <div>
        <div class="TabContent">
            <PostDetail :itemInfo="selectPostItem"
                        :isLike="1"
                        :pInfo="userInfo"
                        v-if="detailShowState"
                        @detailState="detailShowState=false">
            </PostDetail>
            <el-tabs v-model="activeName">
                <el-tab-pane label="帖子" name="first">
                    <div class="ItemContent">
                        <div class="tip" v-if="isPostListNull">
                            <img :src="tipUrl" width="975px">
                        </div>
                        <PersonItems :key="index"
                                     :postItem="userPostList[index]"
                                     v-for="(item,index) in userPostList"
                                     >
                            <template>
                                <el-image :src="userPostList[index].postImg" fit="cover"
                                          style="width: 275px;height: 275px"
                                          @click="postDetail(userPostList[index])">
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
                                <el-image :src="userRecordList[index].postImg" fit="cover"
                                          style="width: 275px;height: 275px">
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
        userInfo:{},
        selectPostItem:{},
        detailShowState:true,
        tipUrl:require("@/assets/Person/tip.png"),
        activeName: 'first',
        isPostListNull:true,
        isRecordListNull:true,
        userPostList: [],
        userRecordList: []
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
        this.detailShowState=true;
        this.selectPostItem=selectItem;
      },
    },
    created() {
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
          // console.log(response)
          for (let index in postList) {
            this.userPostList.push(postList[index])
          }
          for (let index in recordList) {
            this.userRecordList.push(recordList[index])
          }
          if(postList.length) this.isPostListNull = false;
          if(recordList.length) this.isRecordListNull = false;
          // console.log(this.userPostList)
        })
    }
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