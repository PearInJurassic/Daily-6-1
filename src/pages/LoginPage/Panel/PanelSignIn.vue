<template>
    <div style="width: 100%">
        <div class="logo">
            <img alt="logo" src="@/assets/NavBar/logo.png">
        </div>
        <div class="LineWordsLine">
            <span class="line"></span>
            <span class="text">开始注册</span>
            <span class="line"></span>
        </div>
        <div class="SignInPanel">
            <el-form>
                <el-form-item label="用户名">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item label="邮箱号">
                    <el-input></el-input>
                </el-form-item>
                <el-form-item class="TwoButton">
                    <el-button @click="success" type="primary">注册</el-button>
                    <el-button type="info">取消</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PanelSignIn",
    methods: {
      success() {
        this.$notify({
          title: '注册成功',
          message: '您的账号xxxx已经完成注册',
          type: 'success',
          duration: 1500,
        })

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
    }
</style>