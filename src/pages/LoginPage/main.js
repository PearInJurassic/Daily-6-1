import Vue from 'vue'
import App from '@/pages/LoginPage/LoginPage'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueAxios from 'vue-axios';
import axios from 'axios';
import layer from 'vue-layer';
import 'vue-layer/lib/vue-layer.css'
import global_variable from "@/JS/global_variable";

Vue.prototype.$layer = layer(Vue);
Vue.prototype.GLOBAL = global_variable
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueAxios,axios)

new Vue({
  render: h => h(App),
}).$mount('#app')
