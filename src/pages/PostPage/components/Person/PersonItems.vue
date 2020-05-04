<template>
    <div>
        <div class="Item">
            <el-image :src="imgUrl" fit="cover" style="width: 275px;height: 275px">

            </el-image>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PersonItems",
    data() {
      return{
        imgUrl:require("@/assets/plumeria.jpg"),
      }
    },
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