<template>
<div class="AddDialog">
<el-form ref="form" :model="form" label-width="150px">              
  <el-form-item label="你要添加的动态">
    <el-select v-model="form.region" placeholder="你想要添加的动态" @change="currentSel">
      <el-option label="AA" value="shanghai"></el-option>
      <el-option label="BB" value="beijing"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="getItem()">添加</el-button>
    <el-button  @click="cancel()">取消</el-button>
  </el-form-item>
</el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: '',
          selectedItem: ''
        }
      }
    },
    methods: {
      currentSel(selVal) {
      //获取选项名
      this.selectedItem = selVal.value;
      this.$store.commit("getItem","876");
     },
      getItem(){
      
      parent.location.reload(true);//刷新父级页面
      var index1 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
      parent.layer.close(index1); //再执行关闭
     
    },
      cancel:function() {
        parent.location.reload(true);//刷新父级页面
        var index1 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index1); //再执行关闭
        
      },
    }
  }
</script>