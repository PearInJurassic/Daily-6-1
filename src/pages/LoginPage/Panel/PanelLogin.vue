<template>
    <div class="LoginPanelAll">
        <div class="LoginBack">
            <div class="LoginFront">
                <img src="@/assets/NavBar/logo.png">
            </div>
            <div class="LoginPanel">
                <el-form :model="form" label-width="65px">
                    <el-form-item label="用户名">
                        <el-input
                                clearable
                                placeholder="请输入用户名"
                                v-model="form.username">
                        </el-input>
                    </el-form-item>
                    <br>
                    <el-form-item label="密码">
                        <el-input
                                placeholder="请输入密码"
                                show-password
                                v-model="form.password">
                        </el-input>
                    </el-form-item>
                    <br>
                    <div style="padding: 0 20px">
                        <input @click="login" class="CommonButton" id="TextEditButton"
                               type="button" value="登录">
                    </div>
                </el-form>
                <div class="LineWordsLine">
                    <span class="line"></span>
                    <span class="text">有问题?</span>
                    <span class="line"></span>
                </div>
                <div class="ResetPassword">
                    <el-link>忘记密码</el-link>
                </div>
            </div>
            <div class="SignInPanel">
                <span>没有账号？</span>
                <span>
                    <el-link type="primary" @click="signIn">注册</el-link>
                </span>
            </div>
        </div>
        <PanelSignIn v-if="false"></PanelSignIn>
    </div>
</template>

<script>
    import PanelSignIn from "@/pages/LoginPage/Panel/PanelSignIn";
  export default {
    name: "LoginPanel",
    data() {
      return {
        form: {
          username: '',
          password: '',
        }
      }
    },
    components:{
      PanelSignIn,
    },
    methods: {
      login() {
        window.location.href="./PostPage"
      },
      signIn(){
        this.$layer.iframe({
          content:{
            content:PanelSignIn,
            parent:this,
          },
          title:"注册信息",
          area:['400px','600px'],
          btn:'确认',
        });
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .LoginPanelAll {
        display: flex;
        .setSize(100%, 100%);
        justify-content: right;
    }

    .LoginFront {
        .setSize(380px, 100px);
        background: rgba(255, 255, 255, 0.6);
        margin: 15px auto 0 auto;
    }

    .LoginPanel {
        .setSize(380px, 290px);
        background: rgba(255, 255, 255, 0.6);
        margin: 0 auto;
        display: flex;
        flex-direction: column;
        padding-top: 40px;
    }

    .SignInPanel {
        .setSize(380px, 100px);
        background: rgba(255, 255, 255, 0.6);
        margin: 15px auto 15px auto;
        text-align: center;
        display: flex;
        flex-direction: column;
        justify-content: center;

        span {
            font-size: 14px;
        }

        .el-link {
            font-size: 18px;
        }
    }

    .LoginBack {
        .setBorder();
        .setSize(400px, 580px);
        background: rgba(255, 255, 255, 0.6);
        margin: 5% 10% auto 0;
    }

    .el-input {
        width: 300px;
        background-color: white;
    }

    #TextEditButton {
        font-size: 16px;
        letter-spacing: 14px;
    }

    label {
        width: 100%;
        display: flex;
        justify-content: center;
    }

    .ResetPassword {
        padding-top: 20px;
        display: flex;
        justify-content: center;

        .el-link {
            letter-spacing: 2px;
        }
    }

</style>