<template>
    <div>
        <div class="followPerson" v-if="exist">
            <div class="Avatar">
                <el-avatar :size="65"
                           :src="followInfo.userImg">
                </el-avatar>
            </div>
            <div class="NickName">
                <span>{{followInfo.userName}}</span>
            </div>
            <div class="Operation">
                <button @click="gotoOthers" class="CommonButton">查看详情</button>
                <slot>
                    <button @click="cancelFollow" class="CommonButton"
                            v-if="cancelButtonDisable!=1">
                        取消关注
                    </button>
                </slot>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PersonFollowItems",
    data() {
      return {
        exist: true,
      }
    },
    props: {
      followInfo: {},
      cancelButtonDisable: {}
    },
    methods: {
      /**
       * @description 跳转页面
       */
      gotoOthers() {
        if (this.followInfo.userId == sessionStorage.getItem('ID')) {
          this.$router.push('/personpage')
        } else {
          this.$router.push(`/others/${this.followInfo.userId}`)
        }
      },
      /**
       * @description 取消关注
       */
      cancelFollow() {
        let data = new FormData();
        data.append('userId', sessionStorage.getItem("ID"));
        data.append('followId', this.followInfo.userId,)
        // let user = row.userId
        this.axios.get(`${this.GLOBAL.apiUrl}/cancelFollow`, {
          params: {
            userId: sessionStorage.getItem("ID"),
            followId: this.followInfo.userId,
          }
        })
          .then(() => {
            this.exist = false;
            // console.log(response)
          })
          .catch((error) => {
            console.log(error)
          })
      },
    },
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

    .Operation {
        width: 38%;
        display: flex;
        justify-content: space-between;

        .CommonButton {
            margin: auto 5px;
        }
    }
</style>
