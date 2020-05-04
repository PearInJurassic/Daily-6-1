<template>
    <div>
        <el-container style="height: 100%; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1', '3']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>Daily6+1 管理员操作</template>
                        <el-menu-item-group>
                            <template slot="title">查看</template>
                            <el-menu-item index="1-1">查看待审核帖子</el-menu-item>
<!--                            <el-menu-item index="1-2">冻结用户</el-menu-item>-->
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>冻结</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>王小虎</span>
                </el-header>

                <el-main>
                    <el-table :data="tableData" stripe height="100%">
                        <el-table-column prop="id" label="帖子ID" width="140">
                        </el-table-column>
                        <el-table-column prop="content" label="帖子内容" width="320">
                        </el-table-column>
                        <el-table-column prop="posterID" label="被举报贴主ID" width="240">
                        </el-table-column>
                        <el-table-column prop="reportTimes" label="被举报次数" width="180" sortable>
                        </el-table-column>
                        <el-table-column prop="postDate" label="发帖日期" sortable>
                        </el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button @click="handleClick(scope.row)" type="text" size="small">查看详情</el-button>
                                <el-button type="text" size="small">冻结用户</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
  export default {
    name: "AdminPage",
    data() {
      const item = {
        id:"1",
        content:"这是一段测试内容",
        postDate: '2016-05-02',
        posterID: '王小虎',
        reportTimes: '5次'
      };
      return {
        tableData: Array(15).fill(item)
      }
    },
    methods:{
      init() {
        // 请求后端数据,查询数据源
        this.axios({
          method: "get",
          url:"data/index",
        })
          .then((response)=> {
            //TODO 渲染被举报帖子列表
            console.log(response.data.reportedPosts);
            this.tableData=response.data.reportedPosts
          })
          .catch((error)=> {
            console.log(error);
          });
      }
    },
    created(){
      this.init();
    }

  }
</script>

<style scoped>

</style>

<style>
    .el-header {
        background-color: #81878e;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>