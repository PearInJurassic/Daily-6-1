<template>
    <div class="NavSearch">
        <input class="SearchBox" type="text" placeholder="搜索" value="" >
    </div>
</template>

<script>
  export default {
    name: "NavSearch"
  }
</script>

<style scoped lang="less">
    @borderColor:#989899;
    .setNavSearchBorder(@radius:3px) {
        -webkit-border-radius:@radius;
        -moz-border-radius: @radius;
        border-radius: @radius;
    }
    .NavSearch {
        height: 28px;
        width: 975px;
        min-width: 125px;
        display: flex;
        justify-content: center;
        .SearchBox {
            .setNavSearchBorder();
            border: 1px solid @borderColor;
            padding: 3px 10px 3px 26px;
            display: flex;
            max-width: 300px;
            min-width: 150px;
        }
    }

</style>