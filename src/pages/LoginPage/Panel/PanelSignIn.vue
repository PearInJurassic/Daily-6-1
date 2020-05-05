<template>
    <div style="width: 100%">
        <div class="logo">
            <img alt="logo" height="60px" src="@/assets/NavBar/logo.png">
        </div>
        <LineWordLine>开始注册</LineWordLine>
        <div class="SignInPanel">
            <el-form :model="signInForm" :rules="rules">
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="signInForm.email"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input show-password v-model="signInForm.password"></el-input>
                </el-form-item>
                <el-form-item label="昵称" prop="nickName">
                    <el-input v-model="signInForm.nickName"></el-input>
                </el-form-item>
                <el-form-item class="TwoButton">
                    <el-button @click="success" type="primary">注册</el-button>
                    <el-button @click="finish" type="info">取消</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "PanelSignIn",
    data() {
      return {
        signInForm: {
          email: '',
          password: '',
          nickName: '',
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
          ],
          nickName: [
            {
              required: true, message: "请输入您的注册昵称", trigger: 'blur'
            }
          ]
        },
      }
    },
    components: {
      LineWordLine
    },
    methods: {
      success() {
        this.axios.post('http://47.107.77.163:8080/demo/register', {
          "userType": 0,
          "email": this.signInForm.email,
          "userName": this.signInForm.nickName,
          "userPwd": this.signInForm.password
        }).then((response) =>{
          let state = response.data;
          if (state===1) {
            this.$emit("finishSignIn")
            this.$notify({
              title: '注册成功',
              message: `您的账号${this.email}已经完成注册`,
              type: 'success',
              duration: 3500,
            });
          } else {
            this.$notify.error({
              title: '注册失败',
              message: `您的账号${this.email}已经被注册`,
              duration: 3500,
            })
          }
        })
      },
      finish() {
        this.$emit("finishSignIn")
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .logo {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

    .SignInPanel {
        display: flex;
        justify-content: center;
    }

    .TwoButton {
        display: flex;
        justify-content: space-between;
        margin-top: 40px;
    }
</style>