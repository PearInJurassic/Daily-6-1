<template>
    <div class="OptionChild" @click="flag = !flag">
        <slot>
        </slot>
    </div>
</template>

<script>
  export default {
    name: "NavOptionChild",
    data:function () {
        return {
          flag:true,
        }
    }
  }
</script>

<style lang="less" scoped>
    @itemBackColor: #989899;
    .OptionChild {
        padding: 2px 12px;
        margin: 0 5px;
        border-radius: 3px;
        cursor:pointer;
    }
    .OptionChild:hover {
        background-color: @itemBackColor;
        transition: all .3s ease;
    }

</style>