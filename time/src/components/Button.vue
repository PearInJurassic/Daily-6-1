<template>
    <div class="Button">
        
        <button class="confirm">{{text}}</button>
    </div>
</template>

<script>
  
  export default {
    name: "Button",
    components: {
    },
    data(){
    return { //按钮中的文字
      text: this.btnData.text,
      state: false,
    }
  },

   props: {
    btnData: {
      types: Array,
      default() {
        return {
          text: '确认',
        }
      }
    }
  },

    
  }
</script>


<style lang="less" scoped>

.confirm {
  border-radius: 4px;
  font-size: 1.0rem;
  height: 40px;
  line-height:28px;
  width:100px;
  background-color: white;
    color: black;
    border: 1.5px solid black;
  &:focus {
    background-color: black; 
    color: white;
  }
  &:hover {
    background-color: black; 
    color: white;
  }
}

</style>