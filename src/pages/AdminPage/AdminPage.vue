<template>
    <div>
        <el-container style="height: 100%; border: 1px solid #eee">
            <el-aside style="background-color: rgb(238, 241, 246)" width="200px">
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
                    <el-dropdown @command="handleCommand">
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>冻结</el-dropdown-item>
                            <el-dropdown-item command="quit">退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>{{adminInfo.userName}}</span>
                </el-header>

                <el-main>
                    <el-table :data="reportTableData"
                              v-loading="loading"
                              :row-class-name="tableFrozeClass">
                        <el-table-column label="帖子ID" prop="postId" sortable>
                        </el-table-column>
                        <el-table-column label="是否匿名" prop="anonym" width="140">
                        </el-table-column>
                        <el-table-column label="地区信息" prop="areaId" width="140">
                        </el-table-column>
                        <el-table-column label="被举报次数" prop="tipoffNum" width="140">
                        </el-table-column>
                        <el-table-column label="转发次数" prop="forwardNum">
                        </el-table-column>
                        <el-table-column label="帖子内容" prop="postContent" sortable width="320">
                        </el-table-column>
                        <el-table-column label="发帖时间" prop="postCreateTime" sortable>
                        </el-table-column>
                        <el-table-column label="上传时间" prop="postUpdateTime" sortable>
                        </el-table-column>
                        <el-table-column label="用户id" prop="userId" sortable>
                        </el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button @click="handleDetail(scope.row)" size="small" type="text">查看详情</el-button>
                                <el-button @click="handleClick(scope.row)" size="small" type="text">冻结用户</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
            </el-container>
        </el-container>
        <el-dialog
                :visible.sync="dialogVisible"
                title="是否要冻结用户？"
                width="30%">
            <span>确定要冻结该用户吗？</span>
            <span class="dialog-footer" slot="footer">
                <el-button @click="cancelFreeze">取 消</el-button>
                <el-button @click="confirmFrezze" type="primary">确 定</el-button>
            </span>
        </el-dialog>
        <PostDetail v-if="detailDialogVisible"
                    :itemInfo="selectPostItem"
                    :isLike="0"
                    :pInfo="adminInfo"
                    @detailState="changeDetailState">
        </PostDetail>
    </div>
</template>

<script>
    import PostDetail from "@/pages/PostPage/components/Post/PostDetail";
  export default {
    name: "AdminPage",
    data() {
      return {
        detailDialogVisible:false,
        dialogVisible: false,
        loading: true,
        reportTableData: [],
        selectUser:0,
        selectPostItem:{},
        adminInfo:{},
        frozenList:[],
      }
    },
    components:{
      PostDetail
    },
    methods: {
      init() {
        // 请求后端数据,查询数据源
        this.$axios.get(`${this.GLOBAL.apiUrl}/getrequireauditpost`)
          .then((response) => {
            console.log(response)
            let data = response.data.postList;
            for (let index in data) {
              this.reportTableData.push(data[index])
            }
            this.frozenList=response.data.frozenList;
            console.log(this.frozenList)
            this.loading = false;
          })
      },
      handleClick(row) {
        this.selectUser = row.userId,
        this.dialogVisible=true
      },
      /**
       * @description 得到管理员信息
       */
      getAdminInfo() {
        this.axios.get(`${this.GLOBAL.apiUrl}/getUserInfo`,{
          params:{
            userId:sessionStorage.getItem("adminId")
          }
        }).then((response) => {
          this.adminInfo=response.data.userInfo.user;
          // console.log(response)
        })
      },
      /**
       * @description 冻结用户
       */
      confirmFrezze() {
        // let data = new FormData();
        // data.append("userId",this.selectUser)
        this.$axios.post(`${this.GLOBAL.apiUrl}/freeze`,{
          userId:this.selectUser
        })
          .then(() => {
            // console.log(response)
          this.$message({
            message:"冻结成功",
            type:'success',
          })
        })
        this.dialogVisible = false
      },
      cancelFreeze() {
        this.dialogVisible = false
      },
      /**
       * @description 查看详情
       */
      handleDetail(row) {
        this.selectPostItem=row;
        this.detailDialogVisible=true ;
      },
      changeDetailState () {
        this.detailDialogVisible=false;
      },
      /**
       * 冻结用户染色
       */
      tableFrozeClass({row,rowIndex}) {
        console.log(row) //删除会认为row没有被使用过而报错.
        // console.log(this.frozenList[rowIndex])
        if(this.frozenList[rowIndex] == 0)
          return "frozen-row"
        return ''
      },
      /**
       * @description 处理下拉菜单
       */
      handleCommand(command) {
        switch (command) {
            case 'quit':
              window.location.href = "/index.html";
              break;
        }
      }
    },
    created() {
      this.init();
      this.getAdminInfo();
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

    .el-table .frozen-row {
        background-color: #f3b1af;
    }
</style>