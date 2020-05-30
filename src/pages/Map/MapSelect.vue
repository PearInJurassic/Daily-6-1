<template>
  <div class="home">
    <div class="map">
        <country></country>
    </div>

    <div>
        <el-select v-model="value" placeholder="请选择你所在的区块">
            <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
            </el-option>
        </el-select>

    </div>

    <div>
        <el-button type="primary" plain>确定</el-button>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import country from '@/pages/Map/country.vue'

export default {
  name: 'Home',
  components: {
    country
  },
   data() {
      return {
        options: [{
          value: '1',
          label: '区域1'
        }, {
          value: '2',
          label: '区域2'
        }, {
          value: '3',
          label: '区域3'
        }, {
          value: '4',
          label: '区域4'
        }, {
          value: '5',
          label: '区域5'
        }, {
          value: '6',
          label: '区域6'
        }, {
          value: '7',
          label: '区域7' 
        }, {
          value: '8',
          label: '区域8'  
        }, {
          value: '9',
          label: '区域9' 
        }],
        value: ''
      }
    },
  methods: {
    geApitData() {
        //获取城市名
        var n = this.$route.query.n;
        //选择的区块编号
        var num = item.value
    }
  }
}
</script>

<style scoped lang="less">

</style>