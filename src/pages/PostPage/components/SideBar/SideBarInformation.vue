<template>
    <div :style="anonyStyle" class="Information">
        <div class="InformationMain">
            <div class="Avatar">
                <el-avatar :size="52" :src="userAvatar"></el-avatar>
            </div>
            <div>
                <p>{{userNickName}}</p>
            </div>
        </div>
        <div class="InformationButton">
            <slot name="AddButton">
                <button @click="showEditPanel" class="CommonButton">
                    新增帖子
                </button>
                <div class="Anonymous">
                    <button :style="anonyStyle"
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
        isAnonymous: 0,
        anonymousImgAdd: ['Anonymous.png', 'Anonymous-fill.png'],
        anonyStyle: {
          backgroundColor: 'white',
        },
      }
    },
    props: {
      userAvatar: {
        required: true
      },
      userNickName: {
        required: true
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
        if (this.isAnonymous) this.anonyStyle.backgroundColor = "#2c2d2c";
        else this.anonyStyle.backgroundColor = "white";
        if (this.isAnonymous) {
          this.$notify({
            title: '提示',
            message: '您已经进入匿名状态',
            duration: 5000
          });
        }
      }
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .Information {
        .setSize(270px, 80px);
        display: flex;
        justify-content: space-between;
        margin: 0 auto;
        padding-right: 5px;

    }

    .InformationMain {
        .setSize(170px, 70px);
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
        margin-top: 6px;
    }

    .AnonymousButton {
        width: 100%;
        height: 32px;
        border: 0 solid #7f7f7f;
        border-radius: 6px;
    }

</style>