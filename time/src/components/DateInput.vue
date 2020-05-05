<template>
  <div class="block">
    <el-date-picker
      style="width:200px"
      class="a"
      v-model="value2"
      format="yyyy-MM-dd"
      value-format="yyyy-MM-dd"
      @change="getSTime"
      type="daterange"
      align="right"
      unlink-panels
      range-separator="至"
      start-placeholder="开始日期"
      end-placeholder="结束日期"
      size="mini"
      :picker-options="pickerOptions">
    </el-date-picker>
    <br/>
    <br/>
    <el-button  v-on:click="postdate">确定</el-button>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        value1: '',
        value2: '',
      };
    },
    methods: {
      getSTime(val){
        this.value2=val;
      },
      //点击确定按钮后更新vuex的state(起始和中止日期)的值
      postdate(){
        this.$store.commit('setDate',this.value2);
        alert("更新成功！");
      }
    }
  };
</script>
