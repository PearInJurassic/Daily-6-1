<template>
    <div style="display: flex;
        justify-content: right;">
        <div :key="index" class="OptionChild" v-for="(i,index) in list">
            <button @click="change(index)" class="OptionButton">
                <img :alt="iconAlt[index]" :src="i.path===$route.path?list[index].active : list[index].img">
            </button>
        </div>
    </div>
</template>

<script>
  export default {
    name: "NavOptionChild",
    data() {
      return {
        iconAlt: ["可视化地图", "时间轴", "个人空间"],
        pageUrl: ['/postpage', '/mapspage', '/timeaxispage', '/personpage'],

        list: [
          {
            img: require(`@/assets/NavBar/home.png`),
            active: require(`@/assets/NavBar/home-fill.png`),
            path: "/"
          },
          {
            img: require(`@/assets/NavBar/Location.png`),
            active: require(`@/assets/NavBar/Location-fill.png`),
            path: "/mapspage"
          },
          {
            img: require(`@/assets/NavBar/TimeLine.png`),
            active: require(`@/assets/NavBar/TimeLine-fill.png`),
            path: "/timeaxispage"
          },
          {
            img: require(`@/assets/NavBar/PersonSpace.png`),
            active: require(`@/assets/NavBar/PersonSpace-fill.png`),
            path: "/personpage"
          },
        ]
      }
    },
    methods: {
      change(index) {
        // console.log(index)
        this.$router.push(`${this.pageUrl[index]}/id=${sessionStorage.getItem('ID')}`);
        this.$store.commit('setIsAnonymous',0);
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    @itemBackColor: #989899;
    .OptionChild {
        padding: 0 2px;
        margin: 0 3px;
        transition: all .5s ease;

    }

    .OptionButton {
        padding: 2px 13px;
        background-color: white;
        border: 0 white;
        border-radius: 3px;
        box-sizing: border-box;
        cursor: pointer;
    }

    .OptionButton:hover {
        background-color: @itemBackColor;
        transition: all .5s ease;
    }

</style>