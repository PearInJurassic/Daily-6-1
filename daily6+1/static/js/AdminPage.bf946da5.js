(function(e){function t(t){for(var o,i,r=t[0],s=t[1],c=t[2],d=0,p=[];d<r.length;d++)i=r[d],Object.prototype.hasOwnProperty.call(a,i)&&a[i]&&p.push(a[i][0]),a[i]=0;for(o in s)Object.prototype.hasOwnProperty.call(s,o)&&(e[o]=s[o]);u&&u(t);while(p.length)p.shift()();return l.push.apply(l,c||[]),n()}function n(){for(var e,t=0;t<l.length;t++){for(var n=l[t],o=!0,r=1;r<n.length;r++){var s=n[r];0!==a[s]&&(o=!1)}o&&(l.splice(t--,1),e=i(i.s=n[0]))}return e}var o={},a={AdminPage:0},l=[];function i(t){if(o[t])return o[t].exports;var n=o[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.m=e,i.c=o,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var o in e)i.d(n,o,function(t){return e[t]}.bind(null,o));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="";var r=window["webpackJsonp"]=window["webpackJsonp"]||[],s=r.push.bind(r);r.push=t,r=r.slice();for(var c=0;c<r.length;c++)t(r[c]);var u=s;l.push([2,"chunk-vendors","chunk-common"]),n()})({2:function(e,t,n){e.exports=n("30e9")},"30e9":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var o=n("2b0e"),a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-container",{staticStyle:{height:"100%",border:"1px solid #eee"}},[n("el-aside",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[n("el-menu",{attrs:{"default-openeds":["1","3"]}},[n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-message"}),e._v("Daily6+1 管理员操作")]),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("查看")]),n("el-menu-item",{attrs:{index:"1-1"}},[e._v("查看待审核帖子")])],2)],2)],1)],1),n("el-container",[n("el-header",{staticStyle:{"text-align":"right","font-size":"12px"}},[n("el-dropdown",{on:{command:e.handleCommand}},[n("i",{staticClass:"el-icon-setting",staticStyle:{"margin-right":"15px"}}),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[e._v("查看")]),n("el-dropdown-item",[e._v("新增")]),n("el-dropdown-item",[e._v("冻结")]),n("el-dropdown-item",{attrs:{command:"quit"}},[e._v("退出")])],1)],1),n("span",[e._v(e._s(e.adminInfo.userName))])],1),n("el-main",[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.reportTableData,"row-class-name":e.tableFrozeClass}},[n("el-table-column",{attrs:{label:"帖子ID",prop:"postId",sortable:""}}),n("el-table-column",{attrs:{label:"是否匿名",prop:"anonym",width:"140"}}),n("el-table-column",{attrs:{label:"地区信息",prop:"areaId",width:"140"}}),n("el-table-column",{attrs:{label:"被举报次数",prop:"tipoffNum",width:"140"}}),n("el-table-column",{attrs:{label:"转发次数",prop:"forwardNum"}}),n("el-table-column",{attrs:{label:"帖子内容",prop:"postContent",sortable:"",width:"320"}}),n("el-table-column",{attrs:{label:"发帖时间",prop:"postCreateTime",sortable:""}}),n("el-table-column",{attrs:{label:"上传时间",prop:"postUpdateTime",sortable:""}}),n("el-table-column",{attrs:{label:"用户id",prop:"userId",sortable:""}}),n("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"small",type:"text"},on:{click:function(n){return e.handleDetail(t.row)}}},[e._v("查看详情")]),n("el-button",{attrs:{size:"small",type:"text"},on:{click:function(n){return e.handleClick(t.row)}}},[e._v("冻结用户")])]}}])})],1)],1)],1)],1),n("el-dialog",{attrs:{visible:e.dialogVisible,title:"是否要冻结用户？",width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("span",[e._v("确定要冻结该用户吗？")]),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:e.cancelFreeze}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.confirmFrezze}},[e._v("确 定")])],1)]),e.detailDialogVisible?n("PostDetail",{attrs:{itemInfo:e.selectPostItem,isLike:0,pInfo:e.adminInfo},on:{detailState:e.changeDetailState}}):e._e()],1)},l=[],i=n("aed0"),r={name:"AdminPage",data:function(){return{detailDialogVisible:!1,dialogVisible:!1,loading:!0,reportTableData:[],selectUser:0,selectPostItem:{},adminInfo:{},frozenList:[]}},components:{PostDetail:i["a"]},methods:{init:function(){var e=this;this.$axios.get("".concat(this.GLOBAL.apiUrl,"/getrequireauditpost")).then((function(t){console.log(t);var n=t.data.postList;for(var o in n)e.reportTableData.push(n[o]);e.frozenList=t.data.frozenList,console.log(e.frozenList),e.loading=!1}))},handleClick:function(e){this.selectUser=e.userId,this.dialogVisible=!0},getAdminInfo:function(){var e=this;this.axios.get("".concat(this.GLOBAL.apiUrl,"/getUserInfo"),{params:{userId:sessionStorage.getItem("adminId")}}).then((function(t){e.adminInfo=t.data.userInfo.user}))},confirmFrezze:function(){var e=this;this.$axios.post("".concat(this.GLOBAL.apiUrl,"/freeze"),{userId:this.selectUser}).then((function(){e.$message({message:"冻结成功",type:"success"})})),this.dialogVisible=!1},cancelFreeze:function(){this.dialogVisible=!1},handleDetail:function(e){this.selectPostItem=e,this.detailDialogVisible=!0},changeDetailState:function(){this.detailDialogVisible=!1},tableFrozeClass:function(e){var t=e.row,n=e.rowIndex;return console.log(t),0==this.frozenList[n]?"frozen-row":""},handleCommand:function(e){switch(e){case"quit":window.location.href="/index.html";break}}},created:function(){this.init(),this.getAdminInfo()}},s=r,c=(n("d146"),n("2877")),u=Object(c["a"])(s,a,l,!1,null,"f68e83a6",null),d=u.exports,p=n("5c96"),f=n.n(p),m=(n("0fae"),n("a7fe")),b=n.n(m),h=n("bc3a"),g=n.n(h),v=n("d842"),w=n.n(v),y=(n("2ba8"),n("eccf")),x=(n("b72d"),n("c41d"));o["default"].prototype.GLOBAL=x["a"],o["default"].prototype.$axios=g.a,o["default"].prototype.$layer=w()(o["default"]),o["default"].config.productionTip=!1,o["default"].use(f.a),o["default"].use(b.a,g.a),new o["default"]({router:y["a"],render:function(e){return e(d)}}).$mount("#app")},"6c67":function(e,t,n){},"71f3":function(e,t){e.exports=BMap},d146:function(e,t,n){"use strict";var o=n("6c67"),a=n.n(o);a.a}});
//# sourceMappingURL=AdminPage.bf946da5.js.map