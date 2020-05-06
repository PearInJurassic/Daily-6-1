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
