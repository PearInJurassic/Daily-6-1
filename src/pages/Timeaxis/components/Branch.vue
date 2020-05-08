<template>
    <div class="Branch">
        <div class="header">
            <h1 style="display:inline-block">{{axisTypeName}}时间轴</h1>
            <el-button @click="addpage" id="btn">添加</el-button>
            <el-button :style="{ display: editbtn }" id="btn2" v-on:click="setVisible">编辑</el-button>
            <el-button :style="{ display: editcancel }" id="btn3" v-on:click="setVisible">取消编辑</el-button>
        </div>
        <section class="cd-container" id="cd-timeline">

            <div :key="i" id="block1" v-for="(data,i) in datalist">
                <div class="cd-timeline-block" v-if=" (i%2===0 && (data.type===axisTypeName || axisTypeName===''))">
                    <div class="cd-timeline-img cd-picture">
                        <img alt="Picture" src="@/assets/NavBar/TimeLine.png">
                    </div>

                    <div class="cd-timeline-content" style="float:left">

                        <div class="insertmap">
                            <p style="position:absolute;left:5px;top:5px">{{data.date}}</p>
                            <img :src=data.url alt="Picture" style="position: relative;top:20px">
                        </div>
                        <div class="contentpage">
                            <h2 style="display:inline;position:absolute;left:280px;top:40px">{{data.title}}</h2>
                            <el-button :style="{ display: visibleDelete }" @click="fun(i)" circle class="DeleteBtn"
                                       icon="el-icon-delete" type="danger"></el-button>
                            <a class="cd-read-more" href="http://www.helloweba.com/view-blog-285.html"
                               style="position:absolute;left:240px;bottom:50px"
                               target="_blank">查看全文</a>
                        </div>
                    </div>
                </div>

                <div class="cd-timeline-block" v-if="(i%2!==0 && (data.type===axisTypeName || axisTypeName===''))">
                    <div class="cd-timeline-img cd-picture">
                        <img alt="Picture" src="@/assets/NavBar/TimeLine.png">
                    </div>

                    <div class="cd-timeline-content" style="float:right">
                        <div class="insertmap">
                            <p style="position:absolute;left:5px;top:5px">{{data.date}}</p>
                            <img :src=data.url alt="Picture" style="position: relative;top:20px">
                        </div>
                        <div class="contentpage">
                            <h2 style="display:inline;position:absolute;left:280px;top:40px">{{data.title}}</h2>
                            <el-button :style="{ display: visibleDelete }" @click="fun(i)" circle class="DeleteBtn"
                                       icon="el-icon-delete" type="danger"></el-button>
                            <a class="cd-read-more" href="http://www.helloweba.com/view-blog-285.html"
                               style="position:absolute;left:240px;bottom:50px"
                               target="_blank">查看全文</a>
                        </div>
                    </div>

                </div>
            </div>

        </section>

        <el-dialog :modal-append-to-body="modal" :visible.sync="dialogFormVisible" title="动态添加" width="30%">
            <div class="logo">
                <img src="@/assets/NavBar/logo.png">
            </div>
            <div class="PicturePanel">
                <el-upload
                        :action="imgUpLoad.domain"
                        :data="imgUpLoad.postData"
                        :on-preview="handlePictureCardPreview"
                        :on-remove="handleRemove"
                        :on-success="handlePictureSuccess"
                        :on-error="handleError"
                        :before-upload="beforeImgUpload"
                        list-type="picture-card">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog :modal="imgUpLoad.showModal" :visible.sync="imgUpLoad.dialogVisible">
                    <el-image :src="imgUpLoad.dialogImageUrl" alt="" width="100%"></el-image>
                </el-dialog>
            </div>
            <div class="TextPanel">
                <LineWordLine>编辑</LineWordLine>
                <el-form>
                    <el-form-item label="文本内容：">
                        <el-input
                                :row="5"
                                placehoder="请输入内容"
                                type="textarea"
                                v-model="editForm.recordText">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="关联帖子（按时间）">
                        <el-select placeholder="请选择你要进行关联的帖子" v-model="form.region" value-key="id">
                            <el-option :key="item.id" :label="item.title" :value="item"
                                       v-for="item in postListLink"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-button @click="insertRecord">提交</el-button>
                </el-form>
            </div>
        </el-dialog>
    </div>
</template>

<script>
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "Branch",
    components: {
      LineWordLine
    },
    data() {
      return {
        imgUpLoad: {
          domain: 'https://upload.qiniup.com',
          postData: {
            key: null,
            token: '',
          },
          dialogImageUrl: '',
          qiniuaddr: 'http://q9stlq87q.bkt.clouddn.com',
          dialogVisible: false,
          showModal: false,
        },
        editForm: {
          recordText: '',
        },

        modal: false,
        axisTypeName: this.btnData.text, //选择的时间轴类型
        state: false,
        editstate: false,//是否处于编辑状态
        editbtn: '',//编辑按钮显示
        editcancel: 'none',//取消编辑按钮隐藏
        visibleDelete: 'none',   //删除按钮隐藏
        count: this.$store.state.addItem,
        dialogFormVisible: false,
        start: '',
        end: '',
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
        //json文档传入的总列表，展示在时间轴上
        datalist: [],
        //添加列表总列表(datalist用时间筛选后剩下的)
        dataoptions: [],
        //根据类别划分的添加列表
        postListLink: []
      }
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
    computed: {
      //获取起始时间信息
      getstart() {
        return this.$store.state.time.starttime
      },
      //获取终止时间信息
      getend() {
        return this.$store.state.time.endtime
      }
    },
    created() {
      this.init();
      this.getToken();
      this.getPostList();
      // this.geApitData();
      //在页面加载时读取sessionStorage里的状态信息
      if (sessionStorage.getItem("store")) {
        this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("store"))))
      }

      //在页面刷新时将vuex里的信息保存到sessionStorage里
      window.addEventListener("beforeunload", () => {
        sessionStorage.setItem("store", JSON.stringify(this.$store.state))
      })
    },
    methods: {
      /**
       * @description 初始化获得列表
       */
      init() {
        let data = new FormData();
        data.append('userId', sessionStorage.getItem("ID"));
        data.append('timeAxisType', this.axisTypeName)
        this.axios.post(`${this.GLOBAL.apiUrl}/getRecordListByUserIdAndType`, data)
          .then((response) => {
            console.log(response)
            this.datalist = response.data.recordList;
          })
      },
      /**
       * @description 获取七牛云token
       */
      getToken() {
        this.axios.get('http://zzzia.net:8080/qiniu/', {
          params: {
            accessKey: "RwC4uI5jbCfE3IUuokEP7paXOQQA14mcD87MQ6ml",
            secretKey: "o6cPmo7R-QUW4113k1MNNiNjWHOyznj-FERyP_xa",
            bucket: "dailydata"
          }
        }).then((response) => {
          this.imgUpLoad.postData.token = response.data.token
          // this.postData.key = response.data.key
          // console.log(this.imgUpLoad.postData)
        })
      },
      /**
       * @description 获得当前用户的所有帖子
       */
      getPostList() {
        this.axios.get(`${this.GLOBAL.apiUrl}/userPostAndRecordList`, {
          params: {
            userId:sessionStorage.getItem("ID")
          }
        }).then((response) => {
          let postList = response.data.userPostList
          for(let index in postList) {
            this.postListLink.push(postList[index].postCreateTime.split('.')[0]);
          }
          // console.log(this.postListLink)
        }).catch((error) =>{
          console.log(error)
        })
      },
      geApitData() {
        // this.axios({
        //   method: "get",
        //   url: "data/index"
        // })
        //   .then((response) => {
        //     console.log(response)
        //
        //   })
        //   .catch((error) => {
        //     console.log(error);
        //   });
        //json地址
        var url = "/test.json";
        var _this = this;
        this.axios.get(url)
          .then(function (result) {
            _this.datalist = result.data.datalist;
          })
        this.sort();
      },
      //点击添加按钮后添加动态
      add(item) {
        let obj1 = {id: item.id, title: item.title, msg: item.msg, date: item.date, type: item.type, url: item.url};
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
        for (i = 0; i < this.dataoptions.length; i++) {
          if ((this.dataoptions[i].type === this.axisTypeName)) {
            this.dataadd.length = 0;
            this.dataadd.splice(0, 0, this.dataoptions[i]);
          }
        }
      },
      sort() {                     // 排序
        this.datalist.sort(this.compare("date"));
        // 调用下面 compare 方法 并传值
      },
      compare(attr) {                  // 排序方法
        return function (a, b) {
          let val1 = a[attr];
          let val2 = b[attr];
          return new Date(val1.replace(/-/, '/')) - new Date(val2.replace(/-/, '/'));
        }
      },
      //比较ab两个日期的大小,a比b大则返回值大于0
      datecompare(a, b) {
        return new Date(a.replace(/-/, '/')) - new Date(b.replace(/-/, '/'));
      },
      setVisible: function () {

        if (this.editstate === false) {
          this.visibleDelete = ''
          this.editstate = true
          this.editbtn = 'none'
          this.editcancel = ''
        } else {
          this.visibleDelete = 'none'
          this.editstate = false
          this.editbtn = ''
          this.editcancel = 'none'
        }
      },
      //点击删除动态按钮响应
      fun(index) {
        //从动态列表中删去
        var item = this.datalist.splice(index, 1);
        //添加到添加列表中
        this.dataoptions.splice(0, 0, item[0]);
      },
      /**
       * @description 插入新的动态
       */
      insertRecord() {
        this.axios.post(`${this.GLOBAL.apiUrl}/insertRecord`,{
          recordImg:this.imgUpLoad.dialogImageUrl,
          recordContent:this.editForm.recordText,
          timeAxisType:this.btnData.text,
          userId:sessionStorage.getItem("ID")
        }).then((response) =>{
          console.log(response)
        })
      },
      //el-uploader 图片上传处理函数
      beforeImgUpload(file) {
        this.imgUpLoad.postData.key = `upload_pic_${file.name}`
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        // console.log(file)
        this.imgUpLoad.dialogImageUrl = file.url;
        this.imgUpLoad.dialogVisible = true;
      },
      handlePictureSuccess(res) {
        this.imgUpLoad.dialogImageUrl = `${this.imgUpLoad.qiniuaddr}/${res.key}`
        console.log(this.imgUpLoad.dialogImageUrl)
      },
      handleError(res) {
        console.log(res)
      }
    },
    watch: {
      //监听时间轴开始日期变化
      getstart(newVal) {
        //删掉时间轴展示列表里的时间范围外的动态
        var i;
        for (i = 0; i < this.datalist.length; i++) {
          if (this.datecompare(this.datalist[i].date, newVal) < 0) {
            var item = this.datalist.splice(i, 1);
            i--;
            //添加到添加列表中
            this.dataoptions.splice(0, 0, item[0]);
          }
        }
      },
      //监听时间轴中止日期变化
      getend(newVal) {
        //删掉时间轴展示列表里的时间范围外的动态
        var i;
        for (i = 0; i < this.datalist.length; i++) {
          //从展示列表删去
          if (this.datecompare(this.datalist[i].date, newVal) > 0) {
            var item = this.datalist.splice(i, 1);
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
    .header {
        box-shadow: 0 0 5px #7f7f7f;
    }

    html * {
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    *, *:after, *:before {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
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
        margin-top: 2px;
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

    a.cd-read-more:hover {
        text-decoration: none;
        background-color: #424242;
    }

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
            margin: 72px auto 0 auto;
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

    .DeleteBtn {
        position: absolute;
        right: 10px;
        top: 10px;
    }

    .insertmap {
        width: 150px;
        height: 150px;
        float: left;
    }

    .contentpage {
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