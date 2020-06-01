<template>
    <div class="Panel" v-if="isShow">
        <div @click="finishEdit(`close`)"
             class="Mask"></div>
        <div class="EditPanel">
            <div class="PicturePanel">
                <el-upload
                        ref="pictureUploader"
                        :action="domain"
                        :data="postData"
                        :on-preview="handlePictureCardPreview"
                        :on-remove="handleRemove"
                        :on-success="handlePictureSuccess"
                        :before-upload="beforeImgUpload"
                        list-type="picture-card">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog :modal="showModal" :visible.sync="dialogVisible">
                    <el-image :src="dialogImageUrl" alt="" width="100%"></el-image>
                </el-dialog>
            </div>
            <div class="TextPanel">
                <div class="logo">
                    <img src="@/assets/NavBar/logo.png">
                </div>
                <LineWordLine>编辑</LineWordLine>
                <el-form>
                    <el-form-item label="文本内容：">
                        <el-input
                                :row="5"
                                placehoder="请输入内容"
                                type="textarea"
                                v-model="postText">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="Tags（请以空格分隔）">
                        <el-input :disabled="true" v-model="tags"></el-input>
                    </el-form-item>
                    <el-form-item>
                    <input @click="chooseArea" class="CommonButton" id="TextEditButton2" type="button"
                           value="选择地区">
                    </el-form-item>
                    <input @click="finishEdit(`finish`)" class="CommonButton" id="TextEditButton" type="button"
                           value="完成">
                </el-form>
            </div>
            <el-dialog
                    :visible.sync="dialogVisible3"
                    title="地区选择"
                    width="40%">
                <el-form :model="form2">
                    <div>
                        <smallcountry></smallcountry>
                    </div>

                    <span>
                        <el-select v-model="value" placeholder="请选择你所在的区块" @change="showMessage">
                            <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </span>

                    <span>
                          【从下至上从左到右依次为区域1-9块】
                    </span>

                    <div>
                        <el-button @click="finishChoose" class="CommonButton">确定</el-button>
                    </div>

                </el-form>
            </el-dialog>
        </div>
    </div>
</template>

<script>
  import Bus from "@/JS/bus.js"
  import LineWordLine from "@/components/LineWordLine";
  import smallcountry from '@/pages/Map/Mapselect.vue'

  export default {
    name: "PostPanel",
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
          value: '',
          num: -1,
        isShow: true,
        tags: '',
        postText: '',
        dialogImageUrl: '',
        dialogVisible: false,
          dialogVisible3: false,
        showModal: false,
        domain: 'https://upload.qiniup.com',
        qiniuaddr: 'http://q9stlq87q.bkt.clouddn.com',
        postData: {
          key: '',
          token: ''
        },
      }
    },
    methods: {
      /**
       * @description 初始化，获取七牛token
       */
      init() {
        this.userId = sessionStorage.getItem('ID');
        this.axios.get('http://zzzia.net:8080/qiniu/', {
          params: {
            accessKey: "RwC4uI5jbCfE3IUuokEP7paXOQQA14mcD87MQ6ml",
            secretKey: "o6cPmo7R-QUW4113k1MNNiNjWHOyznj-FERyP_xa",
            bucket: "dailydata"
          }
        }).then((response) => {
          this.postData.token = response.data.token
          // this.postData.key = response.data.key
          // console.log(response)
        })
      },
        chooseArea() {
            this.dialogVisible3=true;
        },
        finishChoose() {
            this.dialogVisible3=false;
        },
      /**
       * @description 使用事件总线发送完成编辑信号
       * @param {string} flag 完成信号,可能有"finish"正常结束，和“close"直接关闭。
       */
      finishEdit(flag) {
        let that = this;
        this.axios.post(`${this.GLOBAL.apiUrl}/addpost`, {
          postImg: that.dialogImageUrl,
          postContent: that.postText,
          anonym: 0,
          areaId: this.$store.state.belongedId+this.num,
          userId: sessionStorage.getItem('ID'),
          forwardPostId: -1,
        })
          .then(() => {
            this.postText='';
            this.dialogImageUrl='';
            this.$refs.pictureUploader.clearFiles();
            console.log(this.dialogImageUrl)
            Bus.$emit("finishEdit", flag);
            // console.log(response)
          })
      },
      beforeImgUpload(file) {
        this.postData.key=`upload_pic_${file.name}`;
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        // console.log(file)
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handlePictureSuccess(res) {
        this.dialogImageUrl = `${this.qiniuaddr}/${res.key}`
        console.log(this.dialogImageUrl)
      },
        showMessage(e) {
            //选择的区块编号
            this.num = e
        },
    },
    components: {
      LineWordLine,
        smallcountry
    },
    created() {
      this.init()
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .EditPanel {
        background-color: whitesmoke;
        .setMinSize(850px, 500px);
        .setBorder(0px);
        border-radius: 2px;
        box-shadow: 0 0 3px #2c2d2c;
        position: fixed;
        top: calc(50% - 250px);
        left: calc(50% - 425px);
        z-index: 15;
        display: flex;
    }

    .PicturePanel {
        .setSize(468px, 500px);
        border-right: 1px solid black;
        display: flex;
        flex-wrap: wrap;
        padding-left: 10px;
        padding-top: 15px;
    }

    .logo {
        display: flex;
        justify-content: center;
    }

    .TextPanel {
        width: 350px;
        display: flex;
        flex-direction: column;
        padding: 0 9px;
        justify-content: center;

        label {
            margin: 5px auto;
        }
    }
</style>