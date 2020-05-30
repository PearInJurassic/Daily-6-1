<template>
    <div>
        <div class="LineWordsLine">
            <span class="line"></span>
            <span class="text">
                <slot></slot>
            </span>
            <span class="line"></span>
        </div>
    </div>
</template>

<script>
  export default {
    name: "LineWordLine"
  }
</script>

<style scoped>
    .LineWordsLine {
        margin-top: 15px;
        text-align: center;
    }
    .line {
        display: inline-block;
        width: 25%;
        border-top: 1px solid #ccc;
        margin: 0 6px;
    }

    .text {
        color: #7f7f7f;
        vertical-align: -28%;
        font-size: 14px;
    }
</style>