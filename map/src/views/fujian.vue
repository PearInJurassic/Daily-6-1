

<template>
  <div id="fujian">
  </div>
  
</template>
 
<script>
import BMapGL from 'BMap'
export default {
  name: 'fujian',
  data () {
    return {
      //区块
      datalist:[],
      //色块和本块数据的关系
      colorlist:[
        {
          "color":"#CCEEFF",
          "start":1,
          "end":100
          },
        {
          "color":"#77DDFF",
          "start":101,
          "end":1000
        },
        {
          "color":"#33CCFF",
          "start":1001,
          "end":5000
        },
        {
          "color":"#00BBFF",
          "start":5001,
          "end":10000
        },
        {
          "color":"#0066FF",
          "start":10001,
          "end":100000
        },
      ]
    }
  },
  methods: {
    createMap () {
      /* eslint-disable */
      // 创建Map实例
      var map = new BMapGL.Map("fujian")
      // 初始化地图,设置中心点坐标和地图级别
      map.centerAndZoom(new BMapGL.Point(this.$route.query.x,this.$route.query.y), 11)
      //添加地图类型控件
      map.addControl(new BMapGL.MapTypeControl({
        mapTypes:[BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]
      }))
      // 设置地图显示的城市 此项是必须设置的
      map.setCurrentCity("北京")
      //开启鼠标滚轮缩放
      map.enableScrollWheelZoom(true)
      /* eslint-enable */

      //给区块染色
      //生成随机数据数组
      var t;
      this.datalist.length=0;
      for(t=0;t<10;t++)
      {
        this.datalist.push(Math.random()*(100000-1+1)+1,10);
      }

      var color="orange";
      var turn=0;
      function add_overlay(){
            map.addOverlay(rectangle);         //增加矩形
          }
      var i;
      var n;

      for(i=119;i<119.5;i+=0.15)
        for(n=25.8;n<26.3;n+=0.15)
        {
          //先定义好颜色
          var temp;
          for(temp=0;temp<this.colorlist.length;temp++)
          {
              if(this.datalist[turn]>=this.colorlist[temp].start && this.datalist[turn]<=this.colorlist[temp].end)
              {
                color=this.colorlist[temp].color;
                break;
              }
          }
          turn++;


          var pStart = new BMapGL.Point(i,n);
          var pEnd = new BMapGL.Point(i+0.15,n+0.15);
          var rectangle = new BMapGL.Polygon([
            new BMapGL.Point(pStart.lng,pStart.lat),
            new BMapGL.Point(pEnd.lng,pStart.lat),
            new BMapGL.Point(pEnd.lng,pEnd.lat),
            new BMapGL.Point(pStart.lng,pEnd.lat)
          ], {strokeColor:"white", strokeWeight:2, strokeOpacity:0.5,fillColor:color});  //创建矩形
            //添加覆盖物
          
          
          add_overlay();
        }
        },
  
  },
  mounted () {
    this.createMap()
  }
}
</script>
<style scoped>
  #fujian {
    min-height: 100vh;
  }
</style>