<template>
    <div class="NavOption">
        <slot>
            <NavOptionChild></NavOptionChild>
        </slot>
    </div>
</template>

<script>
  import NavOptionChild from "@/components/Navigation/NavOptionChild";

  export default {
    name: "NavOption",
    components: {
      NavOptionChild,
    }
  }
</script>

<style lang="less" scoped>
    .NavOption {
        max-width: 520px;
        min-width: 175px;
        display: flex;
        justify-content: right;
    }
</style>