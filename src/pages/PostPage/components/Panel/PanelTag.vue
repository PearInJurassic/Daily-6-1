<template>
    <div class="TagAll">
        <el-tag
                :key="index"
                v-for="(tag,index) in dynamicTags"
                closable
                :disable-transitions="false"
                @close="handleClose(tag)">
            {{tag.tagContent}}
        </el-tag>
        <el-input
                class="input-new-tag"
                v-if="inputVisible"
                v-model="inputValue"
                ref="saveTagInput"
                size="small"
                @keyup.enter.native="handleInputConfirm"
                @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
    </div>
</template>

<script>

  export default {
    name: "PanelTag",
    data() {
      return {
        dynamicTags: [],
        inputVisible: false,
        inputValue: ''
      };
    },
    props:{
      item:{
        required:true,
      }
    },
    methods: {
      handleClose(tag) {

        this.axios.get(`${this.GLOBAL.apiUrl}/removetag`,{
          params:{
            tagId:tag.tagId
          }
        }).then((response) =>{
          if(response.data.success) {
            this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            this.$message({
              message:`tag${tag.tagContent}删除成功`,
              type:'success'
            })

          }
        })
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick( () => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          this.axios.post(`${this.GLOBAL.apiUrl}/addtag`,{
              tagContent:inputValue,
              postId:this.item.postId,
          })
            .then((response)=>{
            this.dynamicTags.push(
              {
                tagId:response.data.tagId,
                tagContent: inputValue
              });
          })
        }
        this.inputVisible = false;
        this.inputValue = '';
      }
    },
    created() {
      let that = this;
      this.axios.get(`${this.GLOBAL.apiUrl}//listtag`,{
        params:{
          postId: that.item.postId,
        }
      }).then((response)=>{
        let tagList = response.data.tagList
        for(let index in tagList) {
          this.dynamicTags.push(tagList[index]);
        }
      })
    }
  }
</script>

<style scoped>
    .TagAll {
        margin: 15px 12px;
    }
    .el-tag + .el-tag {
        margin-left: 10px;
    }
    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
    }
</style>