<template>
    <div class="Panel">
        <div class="Mask" @click="closeEditPanel"></div>
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
                <input type="submit" class="CommonButton" id="TextEditButton">
            </div>
        </div>
    </div>
</template>

<script>
import Bus from "@/JS/bus.js"
  export default {
    name: "PostPanel",
    methods:{
      closeEditPanel(){
        Bus.$emit("closeEditPanel",'false');
      }
    }
  }
</script>

<style scoped lang="less">
    @import "../../CSS/Common";
    .Mask {
        background-color: #000000;
        opacity: 0.3;
        position: fixed;
        top:0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 10;
    }
    .EditPanel {
        background-color: whitesmoke;
        .setMinSize(850px,500px);
        .setBorder(0px);
        border-radius: 2px;
        box-shadow: 0 0 3px #2c2d2c;
        position: fixed;
        top:75px;
        left: calc(50% - 425px);
        z-index: 15;
        display: flex;
    }
    .PicturePanel {
        .setMinSize(500px,500px);
        border-right: 1px solid black;
    }
    .TextPanel{
        width: 100%;
        display: flex;
        flex-direction: column;
        padding: 1px 3px;
        label {
            margin: 5px auto;
        }
    }
</style>