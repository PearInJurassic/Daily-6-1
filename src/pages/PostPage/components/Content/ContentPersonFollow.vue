<template>
    <div>
        <div class="FollowList">
            <div :key="index" class="Avatar" v-for="index in followNum">
                <el-avatar
                        :size="72"
                ></el-avatar>
            </div>
            <div class="Icon">
                <button @click="showAllFollow" class="IconButton">
                    <img alt="设置" src="@/assets/Person/others.png">
                </button>
            </div>
        </div>
        <el-drawer
                :visible.sync="drawer"
                direction="ltr"
                title="关注列表">

            <el-table :data="followList">
                <el-table-column prop="head" label="头像"></el-table-column>
                <el-table-column prop="nickName" label="昵称"></el-table-column>
                <el-table-column label="访问">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">查看详情</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-drawer>
    </div>
</template>

<script>
  export default {
    name: "ContentPersonFollow",
    data() {
      return {
        followNum: 5,
        followList:[],
        drawer: false,
      }
    },
    methods: {
      /**
       * @description 展示关注列表
       */
      showAllFollow() {
        this.drawer = true
      },
      handleClick() {

      }
    },
    created() {
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserFollowInfo`,{
        params:{
          userId:sessionStorage.getItem('ID')
        }
      })
      .then(() =>{
        // console.log(response)
      })
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
</style>

<style lang="less">
    .ContentCenter {
        .el-drawer {

        }
    }
</style>