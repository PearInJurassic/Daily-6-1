<template>
    <div>
        <div class="followPerson">
            <div class="Avatar">
                <el-avatar :size="65"
                           :src="followInfo.userImg"></el-avatar>
            </div>
            <div class="NickName">
                <span>{{followInfo.userName}}</span>
            </div>
            <div class="Operation">
                <button class="CommonButton">查看详情</button>
                <button class="CommonButton" @click="cancelFollow">取消关注</button>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PersonFollowItems",
    props:{
      followInfo:{}
    },
    methods:{
      /**
       * @description 取消关注
       */
      cancelFollow() {
        // let user = row.userId
        this.axios.get(`${this.GLOBAL}/cancelFollow`,{
          params: {
            userId: sessionStorage.getItem("ID"),
            followId: this.followInfo.userId,
          }
        })
          .then((response) => {
            console.log(response)
          })
          .catch((error) =>{
            console.log(error)
          })
      },
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";
    .NickName {
        line-height: 75px;
    }
    .followPerson {
        .setSize(100%, 75px);
        padding: 5px;
        margin: 5px auto;
        display: flex;
        justify-content: space-between;
    }
    .Operation{
        width: 38%;
        display: flex;
        justify-content: space-between;
        .CommonButton {
            margin: auto 5px;
        }
    }
</style>
