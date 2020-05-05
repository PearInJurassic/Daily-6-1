import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import layer from 'vue-layer'
import 'vue-layer/lib/vue-layer.css';
import store from './vuex/store' // 引入store
import Vuex from "vuex"
import axios from 'axios'
import VueResource from 'vue-resource'

Vue.prototype.$layer = layer(Vue);
Vue.prototype.$axios=axios;
Vue.use(ElementUI);
Vue.use(Vuex);
Vue.use(VueResource);

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
}).$mount('#app')
