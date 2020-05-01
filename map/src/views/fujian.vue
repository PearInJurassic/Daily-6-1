<template>
  <div class="echarts">
    <div :class="className" :id="id" :style="{height:height,width:width}" ref="myEchart"></div>
    <!-- <Title :title="title"></Title>
    <Search :placeholder="placeholder" :find="find" @listenSearch="searchItem" @listenAdd="addNew" @listenLeadIng="leadingItem"></Search> -->
    <!-- <div id="provinceChart" class="charts" ref="myEchart1" style="height:400px;"></div> -->
  </div>
</template>
<script>
  import echarts from "echarts";
  import '../../node_modules/echarts/map/js/province/fujian.js'
  import '../../node_modules/echarts/map/js/china.js' // 引入中国地图数据

  export default {
    name: "echarts",
    props: {
      className: {
        type: String,
        default: "yourClassName"
      },
      id: {
        type: String,
        default: "yourID"
      },
      width: {
        type: String,
        default: "100%"
      },
      height: {
        type: String,
        default: "400px"
      }
    },
    data() {
      return {
        title: "图表",
        placeholder: "用户名/电话",
        find: "2", //1显示新增按钮，2显示导入按钮，若不显示这两个按钮可以写0或者不写值
        chart: null
      };
    },

    mounted() {
      this.initChart();
      // this.chinaConfigure();
    },
    beforeDestroy() {
      if (!this.chart) {
        return;
      }
      this.chart.dispose();
      this.chart = null;
    },
    methods: {
      chinaConfigure() {
        let myChart = echarts.init(this.$refs.myEchart1); //这里是为了获得容器所在位置
        myChart.setOption({ // 进行相关配置
          backgroundColor: "#02AFDB",
          tooltip: {}, // 鼠标移到图里面的浮动提示框
          dataRange: {
            show: false,
            min: 0,
            max: 1000000,
            text: ['High', 'Low'],
            realtime: true,
            calculable: true,
            color: ['orangered', 'yellow', 'lightskyblue']
          },

          
        })
      },
      //搜索回调
      searchItem(val) {
        console.log(val)
      },
      //新增回调
      addNew(val) {
        console.log(val)
      },
      //导入
      leadingItem(val) {
        console.log(val)
      },
      initChart() {
        this.chart = echarts.init(this.$refs.myEchart);
        window.onresize = echarts.init(this.$refs.myEchart).resize;
        // 把配置和数据放这里
        this.chart.setOption({
          backgroundColor: "#02AFDB",
          title: {
            // text: '在线设备分布',
            left: '40%',
            top: '0px',
            textStyle: {
              color: '#fff',
              opacity: 0.7
            }
          },
          dataRange: {
            show: false,
            min: 0,
            max: 1000000,
            text: ['High', 'Low'],
            realtime: true,
            calculable: true,
            color: ['orangered', 'yellow', 'lightskyblue']
          },
          tooltip: {
            trigger: 'item'
          },
          geo: {
            map: '福建',
             roam: true,
            label: {
              normal: {
                show: true, // 是否显示对应地名
                textStyle: {
                  color: 'rgba(0,0,0,0.4)'
                }
              }
            },
            itemStyle: {
              normal: {
                borderColor: 'rgba(0, 0, 0, 0.2)'
              },
              emphasis: {
                areaColor: null,
                shadowOffsetX: 0,
                shadowOffsetY: 0,
                shadowBlur: 20,
                borderWidth: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          },
          series: [{
            type: 'map',
            mapType: 'fujian',
            // zoom: 1.2,
            mapLocation: {
              y: 100
            },
           
            symbolSize: 12,
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: false
              }
            },
            itemStyle: {
              emphasis: {
                borderColor: '#fff',
                borderWidth: 1
              }
            }
          }],
        });
      }
    }
  }
</script>