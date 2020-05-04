<template>
    <div>
        <div class="FollowList">
            <div class="Avatar" v-for="index in followNum" :key="index">
                <el-avatar
                :size="72"
                ></el-avatar>
            </div>
            <div class="Icon">
                <button  class="IconButton" @click="showAllFollow">
                    <img alt="设置" src="@/assets/Person/others.png">
                </button>
            </div>
        </div>
        <el-drawer
        title="关注列表"
        :visible.sync="drawer"
        direction="ltr">
            <span>11111</span>
        </el-drawer>
    </div>
</template>

<script>
  export default {
    name: "ContentPersonFollow",
    data(){
      return{
        followNum:5,
        drawer:false,
      }
    },
    methods:{
      showAllFollow() {
        this.drawer=true
      }
    }
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .FollowList {
        .setSize(975px,80px);
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