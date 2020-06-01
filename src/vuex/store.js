import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  time: {
    starttime: "hh",
    endtime: "hehe"
  },
  area: "",
  city_name: "",
  highLight: [],//高亮地区id列表
  belongedId: 0
}
/**
 * mutations 里面放置的是我们操作state对象属性的方法
 */
const mutations = {
  setDate(state, a) {
    state.time.starttime = a[0];
    state.time.endtime = a[1];
  },
  setArea(state ,a) {
    state.area = a;
  },
  setCity(state,a) {
    state.city_name = a;
  },
  setHighLight(state,a) {
    state.highLight = a;
  },
  setBelongedId(state,a) {
    state.belongedId = a;
  },
}
export default new Vuex.Store({
  state,
  mutations
})