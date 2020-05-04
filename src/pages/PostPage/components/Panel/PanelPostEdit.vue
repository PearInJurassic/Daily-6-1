<template>
    <div class="Panel" v-show="isShow">
        <div @click="finishEdit(`close`)"
             class="Mask"></div>
        <div class="EditPanel">
            <div class="PicturePanel">
                <el-upload
                        :on-preview="handlePictureCardPreview"
                        :on-remove="handleRemove"
                        action="https://jsonplaceholder.typicode.com/posts/"
                        list-type="picture-card">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible" :modal="showModal">
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
                        <el-input></el-input>
                    </el-form-item>
                    <input @click="finishEdit(`finish`)" class="CommonButton" id="TextEditButton" type="button"
                           value="完成">
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
  import Bus from "@/JS/bus.js"
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "PostPanel",
    data() {
      return {
        isShow: true,
        postText: '',
        dialogImageUrl: '',
        dialogVisible: false,
        showModal:false
      }
    },
    methods: {
      /**
       * @description 使用事件总线发送完成编辑信号
       * @param {string} flag 完成信号,可能有"finish"正常结束，和“close"直接关闭。
       */
      finishEdit(flag) {
        Bus.$emit("finishEdit", flag);
        //添加成功刷新一下

      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
    },
    components:{
      LineWordLine
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