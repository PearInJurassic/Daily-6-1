<template>
    <div class="Side"> 
        <div class="title">
            <p class="text">类别</p>
        </div>
        <br/>       
        <router-link to="/" tag="el-button">全部</router-link>
        <br/>   
        <br/>  
        <router-link to="/about" tag="el-button">日常</router-link>
        <br/>
        <br/>  
        <router-link to="/workline" tag="el-button">工作</router-link>
        <br/>
        <br/>  
        <router-link to="/moodline" tag="el-button" >心情</router-link>
        <br/>
        <br/>  
        <router-link to="/other" tag="el-button">吃喝玩乐</router-link>
        <br/>  
        <br/>
        <div class="title">
            <p>时间</p>
        </div>
        <br/>
        <DateInput></DateInput>
        <br/>
        <br/>
    </div>
</template>


<script>
  import DateInput from "@/components/DateInput.vue";
  export default {
    name: "Side",
    components: {
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