<template>
    <div class="LoginPanelAll">
        <div class="LoginBack">
            <div class="LoginFront">
                <img src="@/assets/NavBar/logo.png">
            </div>
            <div class="LoginPanel">
                <el-form :model="form" :rules="rules" label-width="65px">
                    <el-form-item label="用户名" prop="username">
                        <el-input
                                clearable
                                placeholder="请输入用户名"
                                v-model="form.username">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input
                                placeholder="请输入密码"
                                show-password
                                v-model="form.password">
                        </el-input>
                    </el-form-item>
                    <el-form-item style="display: flex;justify-content: right;padding-right: 20px">
                        <el-switch
                                active-text="我是管理员"
                                inactive-text="我是用户"
                                v-model="loginRole">
                        </el-switch>
                    </el-form-item>
                    <div style="padding: 0 20px">
                        <input @click="login" class="CommonButton" id="TextEditButton"
                               type="button" value="登录">
                    </div>
                </el-form>
                <LineWordLine>有问题？</LineWordLine>
                <div class="ResetPassword">
                    <el-link @click="retrieveCi">忘记密码</el-link>
                </div>
            </div>
            <div class="SignInPanel">
                <span>没有账号？</span>
                <span>
                    <el-link @click="signIn" type="primary">注册</el-link>
                </span>
            </div>
        </div>
        <el-dialog
                :visible.sync="dialogVisible"
                title="注册账号"
                width="400px">
            <PanelSignIn @finishSignIn="finishSignIn"></PanelSignIn>
        </el-dialog>

      <el-dialog 
              :visible.sync="dialogVisible2" 
              title="邮箱验证" 
              width="30%">
        <el-form :model="form2"  :rules="rules">
          <el-form-item label="请输入你的注册邮箱" prop="email">
          <el-input v-model="form2.email"></el-input>
          </el-form-item>
          <el-button @click="emailSend" type="primary">发送验证码</el-button>
        </el-form>      
      </el-dialog>

      <el-dialog 
              :visible.sync="dialogVisible3" 
              title="验证码填写" 
              width="30%">
        <el-form :model="form2"  :rules="rules">
          <el-form-item label="请输入你收到的验证码">
          <el-input v-model="form2.code"></el-input>
          </el-form-item>
          <el-button @click="receiveCode" type="primary">确定</el-button>
        </el-form>      
      </el-dialog>


       <el-dialog 
              :visible.sync="dialogVisible4" 
              title="重置密码" 
              width="30%">
        <el-form :model="form2"  :rules="rules">
          <el-form-item label="请输入你的新密码" prop="password">
          <el-input v-model="form2.password"></el-input>
          </el-form-item>
          <el-button @click="rePassword" type="primary">确定</el-button>
        </el-form>      
      </el-dialog>


    </div>
</template>

<script>
  import PanelSignIn from "@/pages/LoginPage/Panel/PanelSignIn";
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "LoginPanel",
    data() {
      return {
        form: {
          username: '',
          password: '',
        },
        form2: {
          email: '',
          code: '',
          password: ''
        },
        rules: {
           email: [
            {
              required: true, message: "请输入用户名邮箱", trigger: 'blur'
            },
            {
              type: 'email', message: "请输入正确的邮箱地址", trigger: 'blur'
            }
          ],
          username: [
            {
              required: true, message: "请输入用户名邮箱", trigger: 'blur'
            },
            {
              type: 'email', message: "请输入正确的邮箱地址", trigger: 'blur'
            }
          ],
          password: [
            {
              required: true, message: "请输入密码", trigger: 'blur'
            },
            {
              min: 6, max: 28, message: "密码长度在6-18位之间", trigger: 'blur'
            },
            {
              pattern: /^[a-zA-Z](\w){5,17}$/, message: '以字母开头，长度在6-18之间， 只能包含字符、数字和下划线'
            }
          ]
        },
        loginRole: 0,
        dialogVisible: false,
        dialogVisible2: false,
        dialogVisible3: false,
        dialogVisible4: false,
        verCode:0
      }
    },
    components: {
      PanelSignIn,
      LineWordLine
    },
    methods: {
      login() {
        let userType = this.loginRole ? 1 : 0;
        console.log("login")
        this.axios.post('http://47.107.77.163:8080/demo/login', {
          "email": this.form.username,
          "password": this.form.password,
          userType
        })
          .then((response) => {
            console.log(response)
            let state = response.data.code;
            if (state === 1) {
              let userID = response.data.userId;
              if (userType === 0) {
                window.location.href = `./PostPage.html`;
                sessionStorage.setItem("ID", userID);
                sessionStorage.setItem("isFirstLogin",1)
              } else {
                window.location.href = "./AdminPage.html";
                sessionStorage.setItem("adminId", userID)
              }
            } else if (state === 2) {
              this.$notify.error({
                title: '登陆失败',
                message: `您的账号${this.form.username}不存在，请点击注册按钮进行注册`,
                duration: 3500,
              })
            } else if (state === 3) {
              this.$notify.error({
                title: '登陆失败',
                message: `您的密码输入错误`,
                duration: 3500,
              })
            }
          })
      },
      finishSignIn() {
        this.dialogVisible = false;
      },
      signIn() {
        this.dialogVisible = true;
      },
      retrieveCi() {
        this.dialogVisible2 = true;
      },
      emailSend() {
        console.log(this.form2.email)
          this.axios.get(`${this.GLOBAL.apiUrl}/getVerificationCode`, {
            params: {
            emailCode: this.form2.email,
            }
          }).then((response) => {
            this.verCode = response.data.verificationCode  
            this.dialogVisible2 = false;
            this.dialogVisible3 = true;
            console.log(response.data.verificationCode)
            this.$message({
              message:"验证码已发送",
              type:"success",
          })
          
          })
          .catch(function (error) {
          console.log(error);
          })
        
        
      },
      receiveCode() {       
        if(this.verCode==this.form2.code) {
          //进入重置密码界面
          this.dialogVisible3 = false;
          this.dialogVisible4 = true;
           this.$message({
              message:"验证码正确",
              type:"success",
          })
        }
        else {
           this.$message({
              message:"验证码错误",
              type:"warning",
          })
        }
      },
      rePassword() {
         this.axios.get(`${this.GLOBAL.apiUrl}/getVerificationCode`, {
            params: {
            emailCode: this.form2.email,
            }
          }).then((response) => {
            this.verCode = response.data.verificationCode  
            this.dialogVisible2 = false;
            this.dialogVisible3 = true;
            console.log(response.data.verificationCode)
            this.$message({
              message:"验证码已发送",
              type:"success",
          })
          this.dialogVisible4 = false;
          })
          .catch(function (error) {
          console.log(error);
          })
        
      }
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .LoginPanelAll {
        display: flex;
        .setSize(100%, 100%);
        justify-content: flex-end;
    }

    .LoginFront {
        .setSize(380px, 100px);
        background: rgba(255, 255, 255, 0.6);
        margin: 15px auto 0 auto;
        display: flex;
        justify-content: center;
    }

    .LoginPanel {
        .setSize(380px, 310px);
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
        .setSize(400px, 600px);
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