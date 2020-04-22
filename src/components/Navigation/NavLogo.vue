<template>
    <div class="NavIcon">
        <slot>
            <div class="LogoDiv">
                <img src="../../assets/NavBar/logo.png" alt="daily6+1">
            </div>
        </slot>
    </div>
</template>

<script>
  export default {
    name: "NavLogo"
  }
</script>

<style scoped lang="less">
    @color:white;
    .LogoDiv {
        border-width: 2px;
        border-color: black;
        display: flex;
        margin: auto 0;
        cursor:pointer;
        img {
            height: 33px;
        }
    }

    .NavIcon {
        height: 30px;
        background-color: @color;
        display: table-cell;
        text-align: center;
        vertical-align: middle;
        margin: auto 0;
    }
</style>