<template>
    <div class="Information">
        <div class="InformationMain">
            <div class="Avatar">
                <el-avatar :size="52" :src="headUrl"></el-avatar>
            </div>
            <div>
                <p>{{username}}</p>
            </div>
        </div>
        <div class="InformationButton">
            <slot name="AddButton">
                <button @click="showEditPanel" class="CommonButton">
                    新增帖子
                </button>
                <div class="Anonymous">
                    <button :style="anonyButtonStyle"
                            @click="change" class="AnonymousButton">
                        <img :src="anonymousUrl" alt="匿名">
                    </button>
                </div>
            </slot>
        </div>
    </div>
</template>

<script>
  import Bus from "@/JS/bus.js"

  export default {
    name: "SideBarInformation",
    data() {
      return {
        username: 'aassd123lowe',
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        isAnonymous: 0,
        anonymousImgAdd: ['Anonymous-fill.png', 'Anonymous.png'],
        anonyButtonStyle: {
          backgroundColor: '#2c2d2c'
        }
      }
    },
    computed: {
      anonymousUrl() {
        return require(`@/assets/SideBar/${this.anonymousImgAdd[this.isAnonymous]}`);
      }
    },
    components: {},
    methods: {
      /**
       * @description 显示编辑帖子栏
       */
      showEditPanel() {
        Bus.$emit('showEditPanel', 'true')
      },
      /**
       * @description 点击匿名按钮
       */
      change() {
        this.isAnonymous ? this.isAnonymous = 0 : this.isAnonymous = 1;
        if (this.isAnonymous) this.anonyButtonStyle.backgroundColor = "white";
        else this.anonyButtonStyle.backgroundColor = "#2c2d2c"
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .Information {
        .setSize(270px, 80px);
        .setBorder();
        display: flex;
        justify-content: space-between;
        margin: 0 auto;
    }

    .InformationMain {
        .setSize(170px, 70px);
        .setBorder();
        margin: auto 3px;
        display: flex;
        justify-content: left;
    }

    .InformationButton {
        .setSize(100px, 70px);
        margin: auto 0;
    }

    .Anonymous {
        width: 100%;
        display: flex;
        justify-content: center;
        margin-top: 4px;
    }

    .AnonymousButton {
        border: 0 solid #7f7f7f;
        border-radius: 6px;
    }

    .AnonymousButton:visited {
        background-color: whitesmoke;
        border: 0 solid #7f7f7f;
        border-radius: 6px;
    }
</style>