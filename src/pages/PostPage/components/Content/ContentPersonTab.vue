<template>
    <div>
        <div class="TabContent">
            <el-tabs v-model="activeName">
                <el-tab-pane label="帖子" name="first">
                    <div class="ItemContent">
                        <PersonItems :key="index" v-for="index in itemNums"></PersonItems>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="动态" name="second">
                    <div class="ItemContent">
                        <PersonItems :key="index" v-for="index in itemNums"></PersonItems>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
  import PersonItems from "@/pages/PostPage/components/Person/PersonItems";

  export default {
    name: "ContentPersonTab",
    data() {
      return {
        activeName: 'first',
        itemNums: 8,
      }
    },
    components: {
      PersonItems
    },
    methods: {},
    created() {
      this.axios.get(`${this.GLOBAL.apiUrl}/userPostAndRecordList`,{
        params:{
          userId:sessionStorage.getItem("ID")
        }
      })
        .then((response) => {
          console.log(response)
        })
    }
  }
</script>

<style lang="less" scoped>
    @import "~@/CSS/Common.less";

    .TabContent {
        margin-top: 50px;
        .setSize(975px, 600px);
        flex-direction: row;
        justify-content: center;
    }

    .ItemContent {
        display: flex;
        flex-wrap: wrap;
    }

</style>

<style lang="less">
    .TabContent {
        .el-tabs__item{
            font-size: 20px;
            color: black;
            padding-right: 150px;
        }
        .el-tabs__active-bar{
            width: 32px;
            background-color: #7f7f7f;
        }
        .el-tabs__nav-scroll{
            display: flex;
            justify-content: center;
        }
    }
</style>