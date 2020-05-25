<template>
    <div>
        <div class="CommentContent">
            <div class="Comment">
                <div style="display: flex">
                    <div @click="gotoPerson(headComment.userId)" class="Avatar">
                        <el-avatar :src="user.userImg"></el-avatar>
                    </div>
                    <div class="userName">
                        {{user.userName}}
                    </div>
                </div>
                <div class="CommentText">
                    {{headComment.commentContent}}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostCommentChild",
    data() {
      return {
        user: {
          userName: '',
          userImg: ''
        }
      }
    },
    props: {
      headComment: {
        required: true
      }
    },
    methods: {
      change(activeNames) {
        this.$emit('selecHeadComment', activeNames)
      },
      /**
       * @description 跳转到个人空间
       */
      gotoPerson(otherId) {
        if (otherId == sessionStorage.getItem('ID')) {
          this.$router.push('/personpage')
        } else {
          this.$router.push(`/others/${otherId}`)
        }
      },
    },
    created() {
      let userId = this.headComment.userId;
      // console.log(this.headComment.userId)
      this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`, {
        params: {
          userId
        }
      }).then((response) => {
        if(!this.headComment.anonym) {
          this.user.userName = response.data.userInfo.user.userName;
          this.user.userImg = response.data.userInfo.user.userImg;
        } else {
          this.user.userName = '';
          this.user.userImg = this.ANONYMOUS_AVATAR;
        }
      })
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    p {
        word-wrap: break-word;
        word-break: break-all;
    }
    .CommentContent{
        background-color: #fff9f9;
        border-radius: 7px;
        margin: 8px 0;
    }
    .Avatar {
        cursor: pointer;
    }

    .userName {
        margin-top: 20px;
        font-size: 13px;
    }

    .Comment {
        display: flex;
        flex-direction: column;

    }

    .CommentText {
        border-radius: 4px;
        background-color: whitesmoke;
        margin-left: 40px;
        width: calc(100% - 50px);
        padding: 3px 2px 20px 8px;
        margin-bottom: 10px;
    }

    .reply {
        padding-right: 20px;
    }
</style>

