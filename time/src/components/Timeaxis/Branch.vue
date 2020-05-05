<template>
    <div class="Branch">
      <div class="header">
		<h1 style="display:inline-block">{{text}}时间轴</h1>
    <el-button id="btn" @click="addpage">添加</el-button>
    <el-button id="btn2" v-on:click="setVisible" :style="{ display: editbtn }">编辑</el-button>
    <el-button id="btn3" v-on:click="setVisible" :style="{ display: editcancel }">取消编辑</el-button>
	</div>
  <section id="cd-timeline" class="cd-container">

	<div v-for="(data,i) in datalist" :key="i" id="block1">
    <div v-if=" (i%2===0 && (data.type===text || text===''))" class="cd-timeline-block">
      <div class="cd-timeline-img cd-picture">
        <img src="../../assets/NavBar/TimeLine.png" alt="Picture">             
      </div>

      <div class="cd-timeline-content" style="float:left">
       
        <div class="insertmap">
          <p style="position:absolute;left:5px;top:5px">{{data.date}}</p>
          <img :src=data.url alt="Picture" style="position: relative;top:20px">             
        </div>
        <div class="contentpage">
          <h2 style="display:inline;position:absolute;left:280px;top:40px" >{{data.title}}</h2>
          <el-button :style="{ display: visibleDelete }" type="danger" icon="el-icon-delete" circle class="DeleteBtn" @click="fun(i)"></el-button>
          <a href="http://www.helloweba.com/view-blog-285.html" class="cd-read-more" target="_blank" style="position:absolute;left:240px;bottom:50px">查看全文</a>
        </div>
      </div>
    </div>

    <div v-if="(i%2!==0 && (data.type===text || text===''))" class="cd-timeline-block">
      <div class="cd-timeline-img cd-picture">
        <img src="../../assets/NavBar/TimeLine.png" alt="Picture">             
      </div>

      <div class="cd-timeline-content"  style="float:right">
        <div class="insertmap">
        <p style="position:absolute;left:5px;top:5px">{{data.date}}</p>
        <img :src=data.url alt="Picture" style="position: relative;top:20px">             
        </div>
        <div class="contentpage">
        <h2 style="display:inline;position:absolute;left:280px;top:40px">{{data.title}}</h2>
        <el-button :style="{ display: visibleDelete }" type="danger" icon="el-icon-delete" circle class="DeleteBtn" @click="fun(i)"></el-button>       
        <a href="http://www.helloweba.com/view-blog-285.html" class="cd-read-more" target="_blank" style="position:absolute;left:240px;bottom:50px">查看全文</a>
        </div>
      </div>
     
    </div>
  </div>

</section>

<el-dialog title="动态添加" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    
    <el-form-item label="动态" :label-width="formLabelWidth">
      <el-select value-key="id" @change="selectGet" v-model="form.region" placeholder="请选择你要添加的动态">
        <el-option v-for="item in dataadd" :key="item.id"  :label="item.title" :value="item" ></el-option>
        
      </el-select>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button type="primary" @click="add(form.region)">确 定</el-button>
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    
  </div>
</el-dialog>
    </div>
</template>

<script>
import axios from 'axios'
	export default {
	name: "Branch",
	components: {
  },
  computed: {
    //获取起始时间信息
    getstart(){
    return this.$store.state.time.starttime
   },
   //获取终止时间信息
    getend(){
    return this.$store.state.time.endtime
   }
  },
 created () {
    //读入本地的json文件
    this. geApitData();
    //在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem("store") ) {
        this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
    } 

    //在页面刷新时将vuex里的信息保存到sessionStorage里
    window.addEventListener("beforeunload",()=>{
        sessionStorage.setItem("store",JSON.stringify(this.$store.state))
    })
  },
  data(){
    return { 
     
      text: this.btnData.text, //按钮中的文字
      state: false,
      editstate: false,//是否处于编辑状态
      editbtn: '',//编辑按钮显示
      editcancel: 'none',//取消编辑按钮隐藏
      visibleDelete: 'none',   //删除按钮隐藏
      count: this.$store.state.addItem,
      dialogFormVisible: false,
      start:'',
      end:'',
      form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
      formLabelWidth: '120px',
      //json文档传入的总列表，展示在时间轴上
      datalist:[
        
      ],
      //添加列表总列表(datalist用时间筛选后剩下的)
      dataoptions:[
      ],
      //根据类别划分的添加列表
      dataadd:[

      ]
    }
  },
  methods: {
    geApitData() {
      //json地址
      var url="/test.json"; 
      var _this=this;   
      axios.get(url)
          .then(function(result){
            _this.datalist=result.data.datalist;
          })
          this.sort();
    },
    //点击添加按钮后添加动态
    add: function (item){
      let obj1={id:item.id,title:item.title,msg:item.msg,date:item.date,type:item.type,url:item.url};
      this.dialogFormVisible = false;
      //添加到时间轴列表
      this.datalist.splice(0, 0, obj1);
      this.sort();
      //从选择列表中删去
      this.dataoptions.splice(item.id, 1);
    },
    //点击添加按钮
    addpage() {
      this.dialogFormVisible = true;
      var i;
      for(i=0;i<this.dataoptions.length;i++)
      {
        if((this.dataoptions[i].type===this.text) || this.text==='')
        {
          this.dataadd.length = 0;
          this.dataadd.splice(0, 0, this.dataoptions[i]);
        }
      }
    },
    sort(){                     // 排序
      this.datalist.sort(this.compare("date"));
      // 调用下面 compare 方法 并传值
        },
    compare(attr){                  // 排序方法
      return function(a,b){
        let val1 = a[attr];
        let val2 = b[attr];
        return new Date(val1.replace(/-/,'/')) - new Date(val2.replace(/-/,'/'));
      }
},
    //比较ab两个日期的大小,a比b大则返回值大于0
    datecompare(a,b){
      return new Date(a.replace(/-/,'/')) - new Date(b.replace(/-/,'/'));
    },
    setVisible: function() {

      if (this.editstate ===false) {
      this.visibleDelete = ''
      this.editstate =true
      this.editbtn= 'none'
      this.editcancel= ''
      }
      else{
      this.visibleDelete = 'none'
      this.editstate =false
      this.editbtn= ''
      this.editcancel= 'none'
      }    
    },
    //点击删除动态按钮响应
    fun(index) {
      //从动态列表中删去
      var item=this.datalist.splice(index, 1);
      //添加到添加列表中
      this.dataoptions.splice(0, 0, item[0]);

    },
  
  },
   props: {
    btnData: {
      types: Array,
      default() {
        return {
          text: '确认',
        }
      }
    }
  },
  watch: {
    //监听时间轴开始日期变化
    getstart(newVal) {
    //删掉时间轴展示列表里的时间范围外的动态
    var i;
    for(i=0;i<this.datalist.length;i++)
    {
        if(this.datecompare(this.datalist[i].date,newVal)<0)
        {
          var item=this.datalist.splice(i, 1);
          i--;
          //添加到添加列表中
          this.dataoptions.splice(0, 0, item[0]);
        }
    }
      },
    //监听时间轴中止日期变化
        getend(newVal){
       //删掉时间轴展示列表里的时间范围外的动态
      var i;
      for(i=0;i<this.datalist.length;i++)
      {
        //从展示列表删去
        if(this.datecompare(this.datalist[i].date,newVal)>0)
        {
          var item=this.datalist.splice(i, 1);
          i--;
          //添加到添加列表中
          this.dataoptions.splice(0, 0, item[0]);
        }
      }
      }
    }

  }

</script>


<style lang="less" scoped>

html * {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

*, *:after, *:before {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

body {
  font-size: 100%;
  color: #7f8c97;
  background-color: #e9f0f5;
}



img {
  max-width: 100%;
}

/* -------------------------------- 

Modules - reusable parts of our design

-------------------------------- */
.cd-container {
  /* this class is used to give a max-width to the element it is applied to, and center it horizontally when it reaches that max-width */
  width: 90%;
  max-width: 1170px;
  margin: 0 auto;
}


/* -------------------------------- 

Main components 

-------------------------------- */

#cd-timeline {
  position: relative;
  padding: 2em 0;
  margin-top: 2em;
  margin-bottom: 2em;
}
#cd-timeline::before {
  /* this is the vertical line */
  content: '';
  position: absolute;
  top: 0;
  left: 18px;
  height: 100%;
  width: 4px;
  background: #d7e4ed;
}
@media only screen and (min-width: 1170px) {
  #cd-timeline {
    margin-top: 3em;
    margin-bottom: 3em;
  }
  #cd-timeline::before {
    left: 50%;
    margin-left: -2px;
  }
}

.cd-timeline-block {
  position: relative;
  margin: 2em 0;
}
.cd-timeline-block:after {
  content: "";
  display: table;
  clear: both;
}
.cd-timeline-block:first-child {
  margin-top: 0;
}
.cd-timeline-block:last-child {
  margin-bottom: 0;
}
@media only screen and (min-width: 1170px) {
  .cd-timeline-block {
    margin: 4em 0;
  }
  .cd-timeline-block:first-child {
    margin-top: 0;
  }
  .cd-timeline-block:last-child {
    margin-bottom: 0;
  }
}

.cd-timeline-img {
  position: absolute;
  top: 0;
  left: 0;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  box-shadow: 0 0 0 4px white, inset 0 2px 0 rgba(0, 0, 0, 0.08), 0 3px 0 4px rgba(0, 0, 0, 0.05);
}
.cd-timeline-img img {
  display: block;
  width: 24px;
  height: 24px;
  position: relative;
  left: 50%;
  top: 50%;
  margin-left: -12px;
  margin-top: -12px;
}
.cd-timeline-img.cd-picture {
  background: white;
}

@media only screen and (min-width: 1170px) {
  .cd-timeline-img {
    width: 23px;
    height: 23px;
    left: 50%;
    margin-left: -10px;
    /* Force Hardware Acceleration in WebKit */
    -webkit-transform: translateZ(0);
    -webkit-backface-visibility: hidden;
  }
  
}

.cd-timeline-content {
  position: relative;
 border: 1px solid black;
  background: white;
  border-radius: 0.25em;
  padding: 1em;
  box-shadow: 0 3px 0 rgb(97, 97, 94);
}

.cd-timeline-content h2 {
  color: #303e49;
}
.cd-timeline-content p, .cd-timeline-content .cd-read-more, .cd-timeline-content .cd-date {
  font-size: 13px;
  font-size: 0.8125rem;
}
.cd-timeline-content .cd-read-more, .cd-timeline-content .cd-date {
  display: inline-block;
}
.cd-timeline-content p {
  margin: 1em 0;
  line-height: 1.6;
}
.cd-timeline-content .cd-read-more {
  float: right;
  padding: .8em 1em;
  background: #acb7c0;
  color: white;
  border-radius: 0.25em;
}
.no-touch .cd-timeline-content .cd-read-more:hover {
  background-color: #bac4cb;  
}
a.cd-read-more:hover{text-decoration:none; background-color: #424242;  }
.cd-timeline-content .cd-date {
  float: left;
  padding: .8em 0;
  opacity: .7;
}
.cd-timeline-content::before {
  content: '';
  position: absolute;
  top: 16px;
  right: 100%;
  height: 0;
  width: 0;
  border: 7px solid transparent;
  border-right: 7px solid white;
}
@media only screen and (min-width: 768px) {
  .cd-timeline-content h2 {
    font-size: 20px;
    font-size: 1.25rem;
  }
  .cd-timeline-content p {
    font-size: 16px;
    font-size: 1rem;
  }
  .cd-timeline-content .cd-read-more, .cd-timeline-content .cd-date {
    font-size: 14px;
    font-size: 0.875rem;
  }
}
@media only screen and (min-width: 1170px) {
  .cd-timeline-content {
    margin-left: 0;
    padding: 1.6em;
    width: 45%;
  }
  .cd-timeline-content::before {
    top: 24px;
    left: 100%;
    border-color: transparent;
    border-left-color: white;
  }
  .cd-timeline-content .cd-read-more {
	float: left;
  }
  .cd-timeline-content .cd-date {
    position: absolute;
    width: 100%;
    left: 120%;
    top: 6px;
    font-size: 16px;
    font-size: 1rem;
  }
  .cd-timeline-block:nth-child(even) .cd-timeline-content {
    float: right;
  }
  .cd-timeline-block:nth-child(even) .cd-timeline-content::before {
    top: 24px;
    left: auto;
    right: 100%;
    border-color: transparent;
	border-right-color: white;
  }
  .cd-timeline-block:nth-child(even) .cd-timeline-content .cd-read-more {
    float: right;
  }
  .cd-timeline-block:nth-child(even) .cd-timeline-content .cd-date {
    left: auto;
    right: 122%;
    text-align: right;
  }
 
  .header {
    position: relative;
    width: 700px;
    border: 1px solid black;
    border-radius: 0.25em;
    left: 180px;
    top: 48px;
  }
}
  #btn {
    position: relative;
    left: 100px;
  }
  #btn2 {
    position: relative;
    left: 100px;
  }
  #btn3 {
    position: relative;
    left: 100px;
  }
  .DeleteBtn{
    position: absolute;
    right: 10px;
    top: 10px;
  }
  .insertmap{
    width: 150px;
    height: 150px;
    float: left;
  }
  .contentpage{
    width: 200px;
    height: 150px;
    float: right;
  }
@media only screen and (min-width: 1170px) {
  /* inverse bounce effect on even content blocks */
  .cssanimations .cd-timeline-block:nth-child(even) .cd-timeline-content.bounce-in {
    -webkit-animation: cd-bounce-2-inverse 0.6s;
    -moz-animation: cd-bounce-2-inverse 0.6s;
    animation: cd-bounce-2-inverse 0.6s;
  }
}
</style>