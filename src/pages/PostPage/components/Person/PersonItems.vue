<template>
    <div>
        <div class="Item">
<!--            <slot name="post">-->
<!--            <el-image :src="postItem.postImg" fit="cover" style="width: 275px;height: 275px">-->
<!--            </el-image>-->
<!--            </slot>-->
<!--            <slot name="record">-->
<!--                <el-image :src="imgUrl" fit="cover" style="width: 275px;height: 275px">-->
<!--                </el-image>-->
<!--            </slot>-->
            <slot>

            </slot>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PersonItems",
    data() {
      return{
        personPostList:[],
        personTimeList:[],
        imgUrl:require("@/assets/plumeria.jpg"),
      }
    },
    props:{
      postItem:{},
      recordItem:{},
    }
  }
</script>

<style scoped lang="less">
    @import "~@/CSS/Common.less";
    .Item {
        cursor: pointer;
        .setBorder();
        .setSize(275px,275px);
        margin: 20px 20px;
        box-shadow: 0 0 2px gray;
    }

    .Item:hover {

    }
</style>