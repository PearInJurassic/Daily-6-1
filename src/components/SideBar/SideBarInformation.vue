<template>
    <div class="Information">
        <div class="InformationMain"></div>
        <div class="InformationButton">
            <slot name="AddButton">
                <button class="CommonButton" @click="showEditPanel">
                    新增帖子
                </button>
            </slot>
        </div>
    </div>
</template>

<script>
    import Bus from "@/JS/bus.js"
  export default {
    name: "SideBarInformation",
    components: {},
    methods:{
      showEditPanel(){
        Bus.$emit('showEditPanel','true')
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "../../CSS/Common";
    .setBorder(@borderWidth:1px) {
        border-width: @borderWidth;
        border-color: black;
        border-style: solid;
    }

    .setSize(@width,@height) {
        height: @height;
        width: @width;
    }

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
    }

    .InformationButton {
        .setSize(100px, 70px);
        margin: auto 0;
    }

</style>