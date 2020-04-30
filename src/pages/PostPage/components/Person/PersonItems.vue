<template>
    <div>
        <div class="Item">

        </div>
    </div>
</template>

<script>
  export default {
    name: "PersonItems"
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .Item {
        .setBorder();
        .setSize(275px,275px);
        margin: 20px 20px;
    }
</style>