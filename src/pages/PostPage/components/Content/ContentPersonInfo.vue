<template>
    <div>
        <div class="PersonInfo">
            <div class="Avatar">
                <el-avatar
                        :size="180"
                        :src="avatarUrl">
                </el-avatar>
            </div>
            <div class="Information">
                <div class="UserName">
                    <p>aassd123lowe</p>
                </div>
                <div class="DetailInfo">
                    <span>NaN 帖子</span>
                    <span>NaN 粉丝</span>
                    <span>关注</span>
                </div>
                <div class="Icon">
                    <button class="IconButton">
                    <img alt="设置" src="@/assets/Person/setting.png">
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: "ContentPersonInfo",
    data() {
      return {
        avatarUrl: '',
      }
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .Avatar {
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    .PersonInfo {
        .setSize(925px, 230px);
        padding: 20px 20px;
        background-color: white;
        display: flex;
        justify-content: right;
    }

    .Information {
        .setSize(590px, 230px);
        margin-left: 80px;
    }

    .UserName {
        font-size: 32px;
    }

    .DetailInfo {
        span {
            margin-right: 40px;
            font-size: 20px;
        }
    }

    .Icon {
        margin-top: 40px;
        width: 32px;
    }
</style>