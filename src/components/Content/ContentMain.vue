<template>
    <div class="ContentAll">
        <div class="ContentCenter">

        </div>
    </div>
</template>

<script>
  export default {
    name: "ContentMain"
  }
</script>

<style lang="less" scoped>
    @outlineColor:#989899;
    .ContentAll {
        display: flex;
        max-width: 1025px;
        min-width: 650px;
    }
    .ContentCenter {
        max-width: 1025px;
        min-width: 650px;
        border:2px solid @outlineColor;
        padding-top: 30px;
        height: 1200px;
    }
</style>