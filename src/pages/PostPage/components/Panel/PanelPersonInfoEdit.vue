<template>
    <div style="width: 100%;display: flex;flex-direction: row;justify-content: space-between;">
        <div class="InformationPanel">
            <LineWordLine>上传头像</LineWordLine>
            <div class="AvatarUploader">
                <el-upload class="avatar-uploader">
                    <img :src="imageUrl"
                         class="avatar"
                         v-if="imageUrl">
                    <i class="el-icon-plus avatar-uploader-icon" v-else></i>
                </el-upload>
            </div>
            <LineWordLine>修改信息</LineWordLine>
            <div>
                <el-form>
                    <el-form-item label="新的昵称">
                        <el-input></el-input>
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
                        <el-input></el-input>
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
                        <button class="CommonButton">提交</button>
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
        imageUrl: '',
        personText:'',
      };
    },
    components: {
      LineWordLine,
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