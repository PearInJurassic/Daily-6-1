<template>
    <div class="SideBarRecent">

            <LineWordLine>我的最近动态</LineWordLine>
            <component :avatar="avatarUrl"
                       :is="RecentContent"
                       :key="index"
                       :recentInfo="recentNum[index]"
                       v-for="(i,index) in recentNum">
            </component>
        <el-tooltip placement="top" v-if="recentNum.length==0">
            <div slot="content">啊哦！<br/>最近没有发布过动态哦<br/>点击新增帖子分享你最近的生活吧！</div>
            <el-button style="width: 100%;border-width: 0">最近没有动态</el-button>
        </el-tooltip>
    </div>
</template>

<script>
  import PostRecent from "@/pages/PostPage/components/Post/PostRecent";
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "SideBarRecent",
    data() {
      return {
        avatarUrl: this.userAvatar,
        RecentContent: "PostRecent",
        recentNum: [],
        tips: true,
      }
    },
    props: {
      userAvatar: {
        required: true,
      }
    },
    components: {
      PostRecent,
      LineWordLine
    },
    created() {
      if (this.recentNum.length == 0) {
        this.tips = true
      }
      this.axios.get(`${this.GLOBAL.apiUrl}/listpost`, {
        params: {
          userId: sessionStorage.getItem('ID'),
        }
      })
        .then((response) => {
          let recent = response.data.lastpostList;
          for (let r in recent) {
            this.recentNum.push(recent[r]);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }
</script>

<style scoped>
    .SideBarRecent {
        margin: 15px auto;
        box-shadow: 0 0 3px #7f7e7e;
        width: 270px;
        height: 480px;
        padding-top: 1px;
    }

</style>

<style lang="less">
    .SideBarRecent {
        .LineWordsLine {
            margin-bottom: 15px;

            .line {
                width: 70px;
            }

        }
    }
</style>