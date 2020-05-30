<template>
    <div>
        <div :class="personInfoClass">
            <div class="Avatar">
                <el-avatar
                        :size="180"
                        :src="avatarUrl">
                </el-avatar>
            </div>
            <div :class="personInfoDetailClass">
                <div class="UserName" v-cloak>
                    <p>{{userInfo.userNiceName}}</p>
                    <p style="font-size: 13px;padding-top: 40px;padding-left: 50px">{{userInfo.words}}</p>
                </div>
                <div class="DetailInfo">
                    <span>{{userInfo.postNum}} 帖子</span>
                    <el-button type="text"
                               style="font-size: 20px;margin-right: 20px"
                               @click="drawerFans=true">
                        {{userInfo.fansNum}} 粉丝
                    </el-button>
                    <span>关注 {{userInfo.followNum}} 人</span>
                </div>
                <slot name="setting">
                    <div class="Icon">
                        <button @click="editPersonInfo" class="IconButton">
                            <img alt="设置" src="@/assets/Person/setting.png">
                        </button>
                        <button @click="quit" class="IconButton">
                            <img alt="退出登录" src="@/assets/Person/quit.png">
                        </button>
                    </div>
                </slot>
            </div>

            <el-dialog :visible.sync="editDialogVisible"
                       title="修改个人信息"
                       :width="personInfoEditPanelSize">
                <PanelPersonInfoEdit :userInfo="userInfo" @finishEditInfo="closeEdit"></PanelPersonInfoEdit>
            </el-dialog>

            <el-drawer
                    :visible.sync="drawerFans"
                    direction="ltr"
                    title="粉丝列表">
                <PersonFollowItems :followInfo="userInfo.fansList[index]"
                                   :cancelButtonDisable="isOthers"
                                   :key="index"
                                   v-for="(item,index) in userInfo.fansList">
                    <slot>
                        <div></div>
                    </slot>
                </PersonFollowItems>
            </el-drawer>
        </div>
    </div>
</template>

<script>
  import PanelPersonInfoEdit from "@/pages/PostPage/components/Panel/PanelPersonInfoEdit";
    import PersonFollowItems from "@/pages/PostPage/components/Person/PersonFollowItems";
  export default {
    inject: ['reload'],
    name: "ContentPersonInfo",
    data() {
      return {
        windowWidth:document.documentElement.clientWidth,
        drawerFans:false,
        editDialogVisible: false,
        avatarUrl: '',
        userInfo: {
          userNiceName: 'test',
          postNum: NaN,
          fansNum: NaN,
          followNum: NaN,
          words: '输入你的个性签名吧！',
          fansList:[],
        }
      };
    },
    computed:{
      personInfoClass(){
        if(this.windowWidth > 500) {
          return "PersonInfo"
        } else {
          return "mobile_person_info_content"
        }
      },
      personInfoDetailClass(){
        if(this.windowWidth > 500) {
          return "Information"
        } else {
          return "mobile_person_info_detail"
        }
      },
      personInfoEditPanelSize() {
        if(this.windowWidth > 500) {
          return "800px";
        } else {
          return "100%";
        }
      }
    },
    props: {
      isOthers: {}
    },
    components: {
      PanelPersonInfoEdit,
      PersonFollowItems
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

      init(userID) {
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
            // console.log(response)
            this.userInfo.userNiceName = userInfo.user.userName;
            this.avatarUrl = userInfo.user.userImg;
            this.userInfo.postNum = 11;
            this.userInfo.fansNum = userInfo.user.fansNum;
            this.userInfo.followNum = userInfo.user.followNum;
            this.userInfo.words = userInfo.user.profile;
          })
          .catch((error) => {
            console.log(error);
          });
        this.axios.get(`${this.GLOBAL.apiUrl}/getPostNumByUserId`, {
          params: {
            userId: userID
          }
        })
          .then((response) => {
            this.userInfo.postNum = response.data.postNum
            // console.log(this.postNum)
          })
        this.getFansList(userID);
      },
      /**
       * @description 展示粉丝列表
       */
      getFansList(userId) {
        this.axios.get(`${this.GLOBAL.apiUrl}/getUserFansInfo`, {
            params: {
              userId
            }
          }).then((response) =>{
            this.userInfo.fansList=[...response.data.userFansInfo];
            // console.log(this.fansList)
        })
      }
    },
    created() {
      let userID = this.isOthers
        ?
        sessionStorage.getItem('viewId')
        :
        sessionStorage.getItem('ID')
      this.init(userID);
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

    [v-cloak] {
        display: none;
    }

    .PersonInfo {
        .setSize(925px, 230px);
        padding: 20px 20px;
        background-color: white;
        display: flex;
        justify-content: right;
        .Avatar {
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .UserName {
            display: flex;
            font-size: 32px;
        }
    }

    .Information {
        .setSize(590px, 230px);
        margin-left: 80px;
        .DetailInfo {
            span {
                margin-right: 40px;
                font-size: 20px;
            }
        }

    }
    .Icon {
        margin-top: 40px;
        width: 85%;
        background-color: white;
        display: flex;
        flex-direction: row;
        justify-content: right;
    }
    .IconButton {
        background-color: white;
    }
</style>
<style lang="less">
    .el-drawer {
        .ltr{
            width: 80%;
        }
    }
</style>