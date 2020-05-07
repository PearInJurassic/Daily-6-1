<template>
    <div>
        <div class="RecentPost">
            <div class="Avatar">
                <el-avatar :src="avatarUrl"></el-avatar>
            </div>
            <div class="RecentContent">
                {{shortContent}}
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "PostRecent",
    data() {
      return {
        shortContent: this.recentInfo.postContent.substr(0, 35) + "......",
        avatarUrl: this.avatar
      }
    },
    props: {
      recentInfo: {
        required: true
      },
      avatar: {
        required: true,
      }
    },
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    p {
        font-size: 12px;
    }

    .RecentPost {
        margin: 7px auto;
        .setMaxSize(250px, 80px);
        .setMinSize(250px,75px);
        .setBorder();
        display: flex;
        justify-content: left;
    }

    .RecentContent {
        .setMaxSize(186px, 47px);
        .setMinSize(186px,30px);
        margin-top: 20px;
        .setBorder();
        padding: 4px;
        font-size: 12px;
    }
</style>