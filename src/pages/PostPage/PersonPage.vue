<template>
    <div>
        <PageCenterPerson></PageCenterPerson>
    </div>
</template>

<script>
  import PageCenterPerson from "@/pages/PostPage/components/PageCenter/PageCenterPerson";

  export default {
    name: "PersonPage",
    components: {
      PageCenterPerson,
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

</style>