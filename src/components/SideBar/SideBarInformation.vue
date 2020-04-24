<template>
    <div class="Information">
        <div class="InformationMain"></div>
        <div class="InformationButton">
            <slot name="AddButton">
                <button class="CommonButton">
                    新增帖子
                </button>
            </slot>
        </div>
    </div>
</template>

<script>
  export default {
    name: "SideBarInformation",
    components: {}
  }
</script>

<style lang="less" scoped>
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

    .CommonButton {
        .setSize(100%, 30px);
        letter-spacing: 1px;
        padding: 2px;
        font-weight: bold;
        border-radius: 4px;
        border: 0 solid black;
        cursor: pointer;
        transition: all .2s ease;
    }

    .CommonButton:active {
        background-color: black;
        color: white;
    }
</style>