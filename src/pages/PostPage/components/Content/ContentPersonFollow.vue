<template>
    <div>
        <div class="FollowList">
            <div :key="index"
                 @click="gotoOthers(followList[index].userId)"
                 class="Avatar"
                 v-for="(item,index) in followList.slice(0,5)">
                <el-avatar :size="72"
                           :src="followList[index].userImg">
                </el-avatar>
            </div>
            <div class="Icon">
                <button @click="showAllFollow" class="IconButton">
                    <img alt="查看关注列表" src="@/assets/Person/others.png">
                </button>
            </div>
        </div>
        <el-drawer
                :visible.sync="drawer"
                direction="ltr"
                title="关注列表">
            <PersonFollowItems :followInfo="followList[index]"
                               :cancelButtonDisable="isOthers"
                               :key="index"
                               v-for="(item,index) in followList">
            </PersonFollowItems>
        </el-drawer>
    </div>
</template>

<script>
  import PersonFollowItems from "@/pages/PostPage/components/Person/PersonFollowItems";

  export default {

    name: "ContentPersonFollow",
    data() {
      return {
        followNum: 5,
        followList: [],
        drawer: false,
      }
    },
    props: {
      isOthers: {}
    },
    components: {
      PersonFollowItems
    },
    methods: {
      /**
       * @description 展示关注列表
       */
      showAllFollow() {
        this.drawer = true
      },
      /**
       * @description 跳转到他人的个人页面
       * @param otherId 其他用户的ID
       */
      gotoOthers(otherId) {
        if (otherId == sessionStorage.getItem('ID')) {
          this.$router.push('/personpage')
        } else {
          this.$router.push(`/others/${otherId}`)
        }
      }
    },
    created() {
      console.log(`isOthers:${this.isOthers}`)

      let userId = this.isOthers ? sessionStorage.getItem('viewId') : sessionStorage.getItem('ID')
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserFollowInfo`, {
        params: {
          userId
        }
      })
        .then((response) => {
          let list = response.data.userFollowInfo
          for (let index in list) {
            this.followList.push(list[index])
          }
          // console.log(list)
        })
      // console.log(this.isOthers)
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .FollowList {
        .setSize(975px, 80px);
        display: flex;
        flex-direction: row;
        padding-left: 10px;

        .el-avatar {
            margin-right: 30px;
        }
    }

    .Icon {
        display: flex;
        flex-direction: column;
        justify-content: center;
        background-color: white;

        .IconButton {
            background-color: white;
        }
    }

    .Avatar:hover {
        cursor: pointer;
    }
</style>

<style lang="less">
    .ContentCenter {
        .el-drawer {

        }
    }
</style>