import Vue from 'vue'
import App from '@/pages/PostPage/PostPage'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueAxios from 'vue-axios';
import axios from 'axios';
import layer from 'vue-layer';
import 'vue-layer/lib/vue-layer.css';
import router from '@/JS/router'
import store from '@/vuex/store.js' // 引入store
import '@/JS/mock'
import '@/CSS/theme/index.css'
import global_variable from "@/JS/global_variable";
import echarts from 'echarts'

import 'echarts/map/js/province/anhui.js'
import 'echarts/map/js/province/aomen.js'
import 'echarts/map/js/province/beijing.js'
import 'echarts/map/js/province/chongqing.js'
import 'echarts/map/js/province/fujian.js'
import 'echarts/map/js/province/gansu.js'
import 'echarts/map/js/province/guangdong.js'
import 'echarts/map/js/province/guangxi.js'
import 'echarts/map/js/province/guizhou.js'
import 'echarts/map/js/province/hainan.js'
import 'echarts/map/js/province/hebei.js'
import 'echarts/map/js/province/heilongjiang.js'
import 'echarts/map/js/province/hubei.js'
import 'echarts/map/js/province/hunan.js'
import 'echarts/map/js/province/jiangsu.js'
import 'echarts/map/js/province/jiangxi.js'
import 'echarts/map/js/province/jilin.js'
import 'echarts/map/js/province/liaoning.js'
import 'echarts/map/js/province/neimenggu.js'
import 'echarts/map/js/province/ningxia.js'
import 'echarts/map/js/province/qinghai.js'
import 'echarts/map/js/province/shandong.js'
import 'echarts/map/js/province/shanghai.js'
import 'echarts/map/js/province/shanxi.js'
import 'echarts/map/js/province/sichuan.js'
import 'echarts/map/js/province/shanxi1.js'
import 'echarts/map/js/province/taiwan.js'
import 'echarts/map/js/province/tianjin.js'
import 'echarts/map/js/province/xianggang.js'
import 'echarts/map/js/province/xinjiang.js'
import 'echarts/map/js/province/xizang.js'
import 'echarts/map/js/province/yunnan.js'
import 'echarts/map/js/province/zhejiang.js'

import 'echarts/extension/bmap/bmap'

Vue.prototype.$echarts = echarts
Vue.prototype.$layer = layer(Vue);
Vue.prototype.GLOBAL = global_variable
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueAxios,axios)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')