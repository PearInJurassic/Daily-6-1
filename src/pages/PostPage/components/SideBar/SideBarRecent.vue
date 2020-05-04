<template>
    <div class="SideBarRecent">
        <LineWordLine>我的最近动态</LineWordLine>
        <PostRecent></PostRecent>
        <component :is="RecentContent"
                   :key="index"
                   :v-for="(index) in RecentNum">

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
        RecentContent:"PostRecent",
        RecentNum:["1","1"]
      }
    },
    components:{
      PostRecent,
      LineWordLine
    }
  }
</script>

<style scoped>
    .SideBarRecent {
        margin: 15px auto;
        box-shadow: 0 0 3px gray;
        width: 270px;
        height:480px;
        padding-top: 1px;
    }

</style>

<style lang="less">
    .SideBarRecent {
        .LineWordsLine{
            margin-bottom: 15px;
            .line {
                width: 70px;
            }

        }
    }
</style>