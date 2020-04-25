<template>
    <div class="PostContent">
        <div class="PictureContent">
        </div>
        <div style="display: flex">
            <div class="Avatar">
                <el-avatar :size="68" :src="headUrl"></el-avatar>
            </div>
            <div class="Icon">
                <button class="IconButton" id="likeButton" @click="pressLikeButton">
                <img :src="likeUrl" alt="喜欢按钮">
                </button>
            </div>
            <div class="Icon">
                <button class="IconButton" id="ResendButton">
                <img src="../../assets/Post/resend.png" alt="转发按钮">
                </button>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostAll",
    data() {
      return {
        headUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        like:0,
        likeImgArr:['like.png','like-fill.png'],
      }
    },
    computed:{
      likeUrl(){
        return require(`../../assets/Post/${this.likeImgArr[this.like]}`);
      }
    },
    methods:{
      pressLikeButton() {
        this.like?this.like=0:this.like=1;
        console.log(`../../assets/Post/${this.likeImgArr[this.like]}`)
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "../../CSS/Common";

    .PostContent {
        .setSize(650px, 900px);
        margin-bottom: 60px;
        min-height: 900px;
        .setBorder();
    }

    .PictureContent {
        .setSize(650px, 750px);
        .setBorder();
    }

    .Avatar {
        margin: 5px 5px;
    }

    .Icon {
        margin: 5px 5px;
        display: flex;
        flex-direction: column;
        justify-content: flex-end;
        #ResendButton{
            img {
                height: 32px;
            }
        }
    }
</style>