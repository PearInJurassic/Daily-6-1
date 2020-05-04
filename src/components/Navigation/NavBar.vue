<template>
    <div class="NavBar">
        <div class="MidDiv">
            <NavLogo></NavLogo>
            <NavSearch></NavSearch>

            <NavOption></NavOption>
        </div>
    </div>
</template>

<script>
  import NavLogo from "@/components/Navigation/NavLogo";
  import NavSearch from "@/components/Navigation/NavSearch";
  import NavOption from "@/components/Navigation/NavOption";
  export default {
    name: "NavBar",
    components: {
      NavLogo,
      NavSearch,
      NavOption
    },

  }
</script>

<style lang="less" scoped>
    @color: white;
    @layout: center;
    @borderColor:#989899;

    .NavStyle(@padding:0 20px,@height:54px,@width:100%) {
        display: flex;
        height: @height;
        width: @width;
        padding: @padding;
    }

    .MidDiv {
        .NavStyle();
        width: 100%;
        align-items: center;
        max-width: 975px;
        margin: 0 auto;
    }

    .NavBar {
        .NavStyle();
        position: fixed;
        z-index: 5;
        margin: 0;
        background-color: @color;
        border-bottom: solid 1px @borderColor;
        border-top: solid 1px @borderColor;
        align-items: center;
        box-shadow: 0 0 3px #2c2d2c;
    }

</style>