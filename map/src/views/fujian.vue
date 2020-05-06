

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
      //地区数据(以城市为单位)，暂时只存放了福建的城市
      area:[
        {
          //福州
          "id":"10001",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":119.10,//经度
          "lati":25.80,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //莆田
          "id":"10002",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":118.75,//经度
          "lati":25.23,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //泉州
          "id":"10003",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":118.57,//经度
          "lati":24.68,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //厦门
          "id":"10004",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":117.98,//经度
          "lati":24.38,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //漳州
          "id":"10005",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":117.45,//经度
          "lati":24.32,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //龙岩
          "id":"10006",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":116.83,//经度
          "lati":24.90,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //三明
          "id":"10007",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":117.42,//经度
          "lati":26.07,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //南平
          "id":"10008",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":117.87,//经度
          "lati":27.15,//纬度
          "data":[]//对应的12块地区的帖子数
        },
        {
          //宁德
          "id":"10009",
          "color":[],//对应的12块地区显示的渲染颜色
          "long":119.42,//经度
          "lati":26.57,//纬度
          "data":[]//对应的12块地区的帖子数
        }
      ],
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
      //给随机数据数组赋值
      for(var i1=0;i1<this.area.length;i1++)
      {
        var list=[];
        for(var m=0;m<12;m++)
          list.push((Math.random()*100000)+1);
        this.area[i1].data=list;
      }

      //先定义好每块的颜色
      for(var i=0;i<this.area.length;i++)
        for(var n=0;n<12;n++)
          for(var temp=0;temp<this.colorlist.length;temp++)
          {
            if(this.area[i].data[n]>=this.colorlist[temp].start && this.area[i].data[n]<=this.colorlist[temp].end)
            {
              this.area[i].color.push(this.colorlist[temp].color);
              break;
            }
          }
for(var k=0;k<this.colorlist.length;k++)
{console.log(this.colorlist[k].color)}
      function add_overlay(){
            map.addOverlay(rectangle);         //增加矩形
          }

      for(var p=0;p<this.area.length;p++)
      {
        var m1=0;
        for(var i2=this.area[p].long;i2<this.area[p].long+0.45;i2+=0.15)
          for(var n2=this.area[p].lati;n2<this.area[p].lati+0.3;n2+=0.15)
        {
          var pStart = new BMapGL.Point(i2,n2);
          var pEnd = new BMapGL.Point(i2+0.15,n2+0.15);
          var rectangle = new BMapGL.Polygon([
            new BMapGL.Point(pStart.lng,pStart.lat),
            new BMapGL.Point(pEnd.lng,pStart.lat),
            new BMapGL.Point(pEnd.lng,pEnd.lat),
            new BMapGL.Point(pStart.lng,pEnd.lat)
          ], {strokeColor:"white", strokeWeight:2, strokeOpacity:0.5,fillColor:this.area[p].color[m1]});  //创建矩形
            //添加覆盖物
          m1++;
          
          add_overlay();
        }
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