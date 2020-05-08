<template>
    <div style="width: 100%;display: flex;flex-direction: row;justify-content: space-between;">
        <div class="InformationPanel">
            <LineWordLine>上传头像</LineWordLine>
            <div class="AvatarUploader">
                <el-upload
                        class="avatar-uploader"
                        :action="domain"
                        :data="postData"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :on-error="errorHandler"
                        :before-upload="beforeAvatarUpload">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </div>
            <LineWordLine>修改信息</LineWordLine>
            <div>
                <el-form>
                    <el-form-item label="新的昵称">
                        <el-input v-model="nickName"></el-input>
                    </el-form-item>
                </el-form>
            </div>
        </div>
        <div class="InformationPanel">
            <LineWordLine>
                其他信息
            </LineWordLine>
            <div>
                <el-form>
                    <el-form-item label="性别">
                        <el-radio label="男" v-model="genderRadio">男</el-radio>
                        <el-radio label="女" v-model="genderRadio">女</el-radio>
                    </el-form-item>
                    <el-form-item label="个性签名">
                        <el-input
                                :row="3"
                                placehoder="请输入内容"
                                type="textarea"
                                v-model="personText">
                        </el-input>
                    </el-form-item>
                    <div>
                        <button @click.prevent="editInfo" class="CommonButton">提交</button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "PanelPersonInfoEdit",
    data() {
      return {
        userId: 1,
        domain: 'https://upload.qiniup.com',
        postData:{
          key:null,
          token:''
        },
        qiniuaddr: 'http://q9stlq87q.bkt.clouddn.com',
        imageUrl: '',
        nickName: '',
        personText: '',
        genderRadio: '男'
      };
    },
    props: {
      userInfo: {
        required: true
      }
    },
    components: {
      LineWordLine,
    },
    methods: {
      init() {
        this.userId = sessionStorage.getItem('ID');
        this.imageUrl = this.userInfo.userImg
        this.nickName = this.userInfo.userNiceName;
        this.personText = this.userInfo.words;
        this.axios.get('http://zzzia.net:8080/qiniu/',{
          params: {
            accessKey: "RwC4uI5jbCfE3IUuokEP7paXOQQA14mcD87MQ6ml",
            secretKey: "o6cPmo7R-QUW4113k1MNNiNjWHOyznj-FERyP_xa",
            bucket: "dailydata"
          }
        }).then((response) =>{
          this.postData.token=response.data.token
          // this.postData.key = response.data.key
          console.log(this.postData)
        })
      },
      /**
       * @description 提交个人信息修改
       */
      editInfo() {
        this.axios.post(`${this.GLOBAL.apiUrl}/updateUserInfo`, {
          userId: this.userId,
          userName: this.nickName,
          gender: this.genderRadio,
          profile: this.personText,
          userImg:this.imageUrl,
        })
          .then((response) => {
            console.log(response)
            if (response.data.success) {
              this.$message({
                message: "修改个人信息成功",
                type: 'success'
              })
            } else {
              this.$message({
                message: "发生了不可预知的错误，请稍后再试试",
                type: "warning"
              })
            }
            this.$emit('finishEditInfo')
          })
      },
      handleAvatarSuccess(res) {
        // this.imageUrl = URL.createObjectURL(file.raw);
        this.imageUrl = `${this.qiniuaddr}/${res.key}`
        // console.log(res)
        console.log(this.imageUrl)
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        this.postData.key = `upload_pic_${file.name}`
        return isJPG && isLt2M;
      },
      errorHandler(err,file){
        console.log(file)
        console.log(err);
      }
    },
    created() {
      this.init();
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .InformationPanel {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        width: 100%;
        margin: 0 auto;
        .setSize(350px, 425px);
    }

    .AvatarUploader {
        width: 100%;
        margin: 25px auto 0 auto;
        display: flex;
        justify-content: center;
    }


</style>

<style lang="less">
    .avatar-uploader {
        .el-upload {
            border: 1px dashed #828282;
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
        }

        .el-upload:hover {
            border-color: #000000;
        }

        .avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            width: 178px;
            height: 178px;
            line-height: 178px;
            text-align: center;
        }

        .avatar {
            width: 178px;
            height: 178px;
            display: block;
        }
    }
</style>