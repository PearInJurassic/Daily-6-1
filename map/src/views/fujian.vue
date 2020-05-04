<template>
  <div id="map">
  </div>
</template>
 
<script>
import BMap from 'BMap'
export default {
  name: 'Map',
  data () {
    return {
    }
  },
  methods: {
    createMap () {
      /* eslint-disable */
      // 创建Map实例
      var map = new BMap.Map("map")
      // 初始化地图,设置中心点坐标和地图级别
      map.centerAndZoom(new BMap.Point(116.404, 39.915), 11)
      //添加地图类型控件
      map.addControl(new BMap.MapTypeControl({
        mapTypes:[BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]
      }))
      // 设置地图显示的城市 此项是必须设置的
      map.setCurrentCity("北京")
      //开启鼠标滚轮缩放
      map.enableScrollWheelZoom(true)
      /* eslint-enable */
    }
  },
  mounted () {
    this.createMap()
  }
}
</script>
<style scoped>
  #map {
    min-height: 100vh;
  }
</style>