import Vue from 'vue'
import App from '@/Pages/PostPage.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'vue-axios';
import layer from 'vue-layer';
import 'vue-layer/lib/vue-layer.css'

Vue.prototype.$axios = axios;
Vue.prototype.$layer = layer(Vue);
Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
}).$mount('#app')
