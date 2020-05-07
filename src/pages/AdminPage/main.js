import Vue from 'vue'
import App from '@/pages/AdminPage/AdminPage';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueAxios from 'vue-axios';
import axios from 'axios';
import layer from 'vue-layer';
import 'vue-layer/lib/vue-layer.css';
import router from '@/JS/router'
import '@/JS/mock'
import global_variable from "@/JS/global_variable";

Vue.prototype.GLOBAL = global_variable
Vue.prototype.$axios = axios;
Vue.prototype.$layer = layer(Vue);
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueAxios,axios)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
