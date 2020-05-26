<template>
    <div class="main">
        <LoginPanel></LoginPanel>
    </div>
</template>

<script>
  import LoginPanel from "@/pages/LoginPage/Panel/PanelLogin";

  export default {
    name: "LoginPage",
    data() {
      return {}
    },
    components: {
      LoginPanel
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

</style>