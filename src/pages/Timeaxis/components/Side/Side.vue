<template>
    <div class="Side">
        <div class="title">
            <p class="text">类别</p>
        </div>
        <div>
            <button class="CommonButton" @click="jump(0)">
                全部
            </button>
            <button class="CommonButton" @click="jump(1)">
                日常
            </button>
            <button class="CommonButton" @click="jump(2)">
                工作
            </button>
            <button class="CommonButton" @click="jump(3)">
                心情
            </button>
            <button class="CommonButton" @click="jump(4)">
                吃喝玩乐
            </button>
        </div>
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
  import DateInput from "@/pages/Timeaxis/components/Side/DateInput";


  export default {
    name: "Side",
    data() {
      return {
        axisUrl: [`/timeaxispage/id=${sessionStorage.getItem('ID')}`,
          `/timeaxispage/id=${sessionStorage.getItem('ID')}/about`,
          `/timeaxispage/id=${sessionStorage.getItem('ID')}/workline`,
          `/timeaxispage/id=${sessionStorage.getItem('ID')}/moodline`,
          `/timeaxispage/id=${sessionStorage.getItem('ID')}/other`]
      }
    },
    components: {
      DateInput
    },
    methods: {
      jump(value) {
        this.$router.push(this.axisUrl[value])
      }
    }
  }
</script>


<style lang="less" scoped>
    @import "~@/CSS/Common";
    .CommonButton {
        background-color: white;
        margin: 8px 0;
    }

    .Side {
        width: 200px;
    }

    .title {
        width: 200px;
        border: 1px solid black;
        border-left: none;
        border-right: none;
    }
</style>