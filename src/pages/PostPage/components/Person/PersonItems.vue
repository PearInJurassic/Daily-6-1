<template>
    <div>
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
    </div>
</template>

<script>
  export default {
    name: "PersonItems",
    data() {
      return {
        detailShowState: false,
      }
    },
    props: {
      postItem: {},
      recordItem: {},
    },
    methods: {},
    created() {
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`, {
        params: {
          userId: sessionStorage.getItem("ID")
        }
      }).then((response) => {
        this.userInfo = response.data.userInfo.user;
        // console.log(response)
      })
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .Item {
        cursor: pointer;
        .setBorder();
        .setSize(275px, 275px);
        margin: 20px 20px;
        box-shadow: 0 0 2px gray;
    }

    .Item:hover {

    }
</style>