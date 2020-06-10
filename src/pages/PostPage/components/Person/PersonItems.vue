<template>
    <div>
        <div>
            <div :class="itemClass">
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
        windowWidth: document.documentElement.clientWidth,
        detailShowState: false,
      }
    },
    computed:{
      itemClass() {
        if(this.windowWidth < 500){
          return "mobile_person_item"
        } else {
          return "Item"
        }
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
    },
    watch: {
      '$store.state.screenWidth': function (val) { //监听屏幕宽度变化
        this.windowWidth = val;
      }
    },
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