<template>
    <div class="Panel" v-show="isShow">
        <div @click="finishEdit(`close`)"
             class="Mask"></div>
        <div class="EditPanel">
            <div class="PicturePanel"></div>
            <div class="TextPanel">
                <label>
                    <input type="text">
                </label>
                <label>
                    <input type="text">
                </label>
                <label>
                    <input type="text">
                </label>
                <input @click="finishEdit(`finish`)" class="CommonButton" id="TextEditButton" type="submit">
            </div>
        </div>
    </div>
</template>

<script>
  import Bus from "@/JS/bus.js"

  export default {
    name: "PostPanel",
    data() {
      return {
        isShow: true,
      }
    },
    methods: {
      /**
       * @description 使用事件总线发送完成编辑信号
       * @param {string} flag 完成信号,可能有"finish"正常结束，和“close"直接关闭。
       * @author soushu
       */
      finishEdit(flag) {
        Bus.$emit("finishEdit", flag);
        //添加成功刷新一下
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "../../CSS/Common";

    .Mask {
        background-color: #000000;
        opacity: 0.3;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 10;
    }

    .EditPanel {
        background-color: whitesmoke;
        .setMinSize(850px, 500px);
        .setBorder(0px);
        border-radius: 2px;
        box-shadow: 0 0 3px #2c2d2c;
        position: fixed;
        top: 75px;
        left: calc(50% - 425px);
        z-index: 15;
        display: flex;
    }

    .PicturePanel {
        .setMinSize(500px, 500px);
        border-right: 1px solid black;
    }

    .TextPanel {
        width: 100%;
        display: flex;
        flex-direction: column;
        padding: 1px 3px;

        label {
            margin: 5px auto;
        }
    }
</style>