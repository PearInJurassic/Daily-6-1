<template>
    <div class="Side"> 
        <div class="title">
            <p class="text">类别</p>
        </div>
        <br/>   
        <br/>   
        <Button :btnData="{text: '日常'}"></Button>

        <br/>
        <Button :btnData="{text: '工作'}"></Button>
        <br/>
        <Button :btnData="{text: '心情'}"></Button>
        <br/>
        <Button :btnData="{text: '吃喝玩乐'}"></Button>
        <br/>
        <br/>
        <div class="title">
            <p>时间</p>
        </div>
        <DateInput></DateInput>
    </div>
</template>


<script>
  
  import Button from "@/components/Button.vue";
  import DateInput from "@/components/DateInput.vue";
  export default {
    name: "Side",
    components: {
      Button,
      DateInput
    },
  }
</script>


<style lang="less" scoped>

.Side {
    width: 200px;
}
.title{
    width: 200px;
    border: 1px solid black;  
    border-left:none;
    border-right:none;
}
</style>