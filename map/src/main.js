import Vue from 'vue'
import App from './App.vue'
import router from './router'
import echarts from 'echarts'
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

import '../node_modules/echarts/map/js/province/beijing.js' // 引入北京地图数据
import '../node_modules/echarts/map/js/province/fujian.js' // 引入福建地图数据
import '../node_modules/echarts/map/js/province/anhui.js' // 引入安徽地图数据
import '../node_modules/echarts/map/js/province/xinjiang.js' // 引入新疆地图数据
import '../node_modules/echarts/map/js/province/xizang.js' // 引入西藏地图数据


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
