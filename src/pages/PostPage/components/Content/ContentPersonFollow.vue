<template>
    <div>
        <div class="FollowList">
            <div class="Avatar" v-for="index in followNum" :key="index">
                <el-avatar
                :size="72"
                ></el-avatar>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "ContentPersonFollow",
    data(){
      return{
        followNum:5,
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
</style>