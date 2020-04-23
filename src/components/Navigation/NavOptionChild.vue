<template>
    <div class="OptionChild" @click="changeIconState">
        <button class="OptionButton">
        <slot>
        </slot>
        </button>
    </div>
</template>

<script>
  export default {
    name: "NavOptionChild",
    data() {
        return {
          flag:true,
        }
    },
    methods:{
      changeIconState(){
        console.log(this)
      }
    }
  }
</script>

<style lang="less" scoped>
    @itemBackColor: #989899;
    .OptionChild {
        padding: 0 2px;
        margin: 0 3px;
        cursor:pointer;
        transition: all .5s ease;

    }
    .OptionButton {
        padding: 2px 13px;
        background-color: white;
        border: 0 white;
        border-radius: 3px;
        box-sizing: border-box;
    }
    .OptionButton:hover {
        background-color: @itemBackColor;
        transition: all .5s ease;
    }
</style>