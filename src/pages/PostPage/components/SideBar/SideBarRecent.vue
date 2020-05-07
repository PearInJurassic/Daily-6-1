<template>
    <div class="SideBarRecent">
        <LineWordLine>我的最近动态</LineWordLine>
        <component :is="RecentContent"
                   :key="index"
                   :recentInfo="recentNum[index]"
                   :avatar="avatarUrl"
                   v-for="(i,index) in recentNum">
        </component>
    </div>
</template>

<script>
  import PostRecent from "@/pages/PostPage/components/Post/PostRecent";
  import LineWordLine from "@/components/LineWordLine";

  export default {
    name: "SideBarRecent",
    data() {
      return {
        avatarUrl:this.userAvatar,
        RecentContent: "PostRecent",
        recentNum: []
      }
    },
    props:{
      userAvatar:{
        required:true,
      }
    },
    components: {
      PostRecent,
      LineWordLine
    },
    created() {
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
        box-shadow: 0 0 3px gray;
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