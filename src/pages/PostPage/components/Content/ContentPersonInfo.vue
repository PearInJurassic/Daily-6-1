<template>
    <div>
        <div class="PersonInfo">
            <div class="Avatar">
                <el-avatar
                        :size="180"
                        :src="avatarUrl">
                </el-avatar>
            </div>
            <div class="Information">
                <div class="UserName">
                    <p>{{userNiceName}}</p>
                    <p style="font-size: 13px;padding-top: 40px;padding-left: 50px">{{words}}</p>
                </div>
                <div class="DetailInfo">
                    <span>{{postNum}} 帖子</span>
                    <span>{{fansNum}} 粉丝</span>
                    <span>关注 {{followNum}} 人</span>
                </div>
                <div class="Icon">
                    <button @click="editPersonInfo" class="IconButton">
                        <img alt="设置" src="@/assets/Person/setting.png">
                    </button>
                    <button @click="quit" class="IconButton">
                        <img alt="退出登录" src="@/assets/Person/quit.png">
                    </button>
                </div>
            </div>
            <PanelPersonInfoEdit v-if="false"></PanelPersonInfoEdit>
        </div>
    </div>
</template>

<script>
  import PanelPersonInfoEdit from "@/pages/PostPage/components/Panel/PanelPersonInfoEdit";

  export default {
    name: "ContentPersonInfo",
    data() {
      return {
        avatarUrl: '',
        userNiceName: 'test1234',
        postNum: NaN,
        fansNum: NaN,
        followNum: NaN,
        words: '',
      };
    },
    components: {
      PanelPersonInfoEdit
    },
    methods: {
      editPersonInfo() {
        this.$layer.iframe({
          content: {
            content: PanelPersonInfoEdit,
          },
          title: "修改信息",
          area: ['800px', '500px'],
        })
      },
      quit() {
        window.location.href = "/index.html";
      },
      //mock方法
      init() {
        // 请求后端数据,查询数据源
        this.axios({
          method: "get",
          url: "data/index",
        })
          .then((response) => {
            console.log(response.data.user)
            this.userNiceName = response.data.user.name;
            this.postNum = response.data.user.postNum;
            this.fansNum = response.data.user.fansNum;
            this.followNum = response.data.user.followNum;
            this.words = response.data.user.words;
          })
          .catch((error) => {
            console.log(error);
          });
      },

    },
    created() {
      this.init();
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .Avatar {
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    .UserName {
        display: flex;
    }

    .PersonInfo {
        .setSize(925px, 230px);
        padding: 20px 20px;
        background-color: white;
        display: flex;
        justify-content: right;
    }

    .Information {
        .setSize(590px, 230px);
        margin-left: 80px;
    }

    .UserName {
        font-size: 32px;
    }

    .DetailInfo {
        span {
            margin-right: 40px;
            font-size: 20px;
        }
    }

    .Icon {
        margin-top: 40px;
        width: 32px;
        display: flex;
        flex-direction: row;
        justify-content: left;
    }

    .IconButton {
        background-color: white;
    }
</style>