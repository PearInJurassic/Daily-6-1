import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    time:{
        starttime:"hh",
        endtime:"hehe"
    }
}
/**
 * mutations 里面放置的是我们操作state对象属性的方法
 */
const mutations = {
    setDate(state ,a) {
        state.time.starttime=a[0];
        state.time.endtime=a[1];
    },
   
}
export default new Vuex.Store({
    state,
    mutations
})