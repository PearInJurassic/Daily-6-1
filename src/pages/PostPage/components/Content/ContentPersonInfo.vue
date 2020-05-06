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
                <div class="UserName" v-cloak>
                    <p>{{userInfo.userNiceName}}</p>
                    <p style="font-size: 13px;padding-top: 40px;padding-left: 50px">{{userInfo.words}}</p>
                </div>
                <div class="DetailInfo">
                    <span>{{userInfo.postNum}} 帖子</span>
                    <span>{{userInfo.fansNum}} 粉丝</span>
                    <span>关注 {{userInfo.followNum}} 人</span>
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
            <el-dialog :visible.sync="editDialogVisible"
                       title="修改个人信息"
                       width="800px">
                <PanelPersonInfoEdit @finishEditInfo="closeEdit" :userInfo="userInfo"></PanelPersonInfoEdit>
            </el-dialog>
        </div>
    </div>
</template>

<script>
  import PanelPersonInfoEdit from "@/pages/PostPage/components/Panel/PanelPersonInfoEdit";

  export default {
    inject:['reload'],
    name: "ContentPersonInfo",
    data() {
      return {
        editDialogVisible: false,
        avatarUrl: '',
        userInfo: {
          userNiceName: 'test',
          postNum: NaN,
          fansNum: NaN,
          followNum: NaN,
          words: '输入你的个性签名吧！',
        }
      };
    },
    components: {
      PanelPersonInfoEdit
    },
    methods: {
      editPersonInfo() {
        this.editDialogVisible = true;
      },
      closeEdit() {
        this.editDialogVisible = false;
        this.reload();
      },
      quit() {
        window.location.href = "/index.html";
      },

      init() {
        let userID = sessionStorage.getItem('ID');
        // 请求后端数据,查询数据源
        this.axios.get('http://47.107.77.163:8080/demo/getUserInfo',
          {
            params: {
              userId: userID
            }
          }
        )
          .then((response) => {
            let userInfo = response.data.userInfo;
            console.log(response)
            this.userInfo.userNiceName = userInfo.user.userName;
            this.userInfo.postNum = 11;
            this.userInfo.fansNum = userInfo.user.fansNum;
            this.userInfo.followNum = userInfo.user.followNum;
            this.userInfo.words = userInfo.user.profile;
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

    [v-cloak] {
        display: none;
    }

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