import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    starttime: null,
    endtime: null
}
/**
 * mutations 里面放置的是我们操作state对象属性的方法
 */
const mutations = {
    setDate(state ,a,b) {
        state.starttime=a;
        state.endtime=b;
    },
   
}
export default new Vuex.Store({
    state,
    mutations
})