<template>
    <div>
        <PageCenterOther></PageCenterOther>
    </div>
</template>

<script>
  import PageCenterOther from "@/pages/PostPage/components/PageCenter/PageCenterOther";
  export default {
    name: "OthersPage",

    components: {
      PageCenterOther,
    },
    created() {
      sessionStorage.setItem('viewId',this.$route.params.id)
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

</style>