(function(e){function i(i){for(var n,r,a=i[0],l=i[1],c=i[2],m=0,d=[];m<a.length;m++)r=a[m],Object.prototype.hasOwnProperty.call(s,r)&&s[r]&&d.push(s[r][0]),s[r]=0;for(n in l)Object.prototype.hasOwnProperty.call(l,n)&&(e[n]=l[n]);u&&u(i);while(d.length)d.shift()();return o.push.apply(o,c||[]),t()}function t(){for(var e,i=0;i<o.length;i++){for(var t=o[i],n=!0,a=1;a<t.length;a++){var l=t[a];0!==s[l]&&(n=!1)}n&&(o.splice(i--,1),e=r(r.s=t[0]))}return e}var n={},s={index:0},o=[];function r(i){if(n[i])return n[i].exports;var t=n[i]={i:i,l:!1,exports:{}};return e[i].call(t.exports,t,t.exports,r),t.l=!0,t.exports}r.m=e,r.c=n,r.d=function(e,i,t){r.o(e,i)||Object.defineProperty(e,i,{enumerable:!0,get:t})},r.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.t=function(e,i){if(1&i&&(e=r(e)),8&i)return e;if(4&i&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(r.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&i&&"string"!=typeof e)for(var n in e)r.d(t,n,function(i){return e[i]}.bind(null,n));return t},r.n=function(e){var i=e&&e.__esModule?function(){return e["default"]}:function(){return e};return r.d(i,"a",i),i},r.o=function(e,i){return Object.prototype.hasOwnProperty.call(e,i)},r.p="";var a=window["webpackJsonp"]=window["webpackJsonp"]||[],l=a.push.bind(a);a.push=i,a=a.slice();for(var c=0;c<a.length;c++)i(a[c]);var u=l;o.push([0,"chunk-vendors","chunk-common"]),t()})({0:function(e,i,t){e.exports=t("e7b5")},"0dfa":function(e,i,t){"use strict";var n=t("c3d5"),s=t.n(n);s.a},"12b2":function(e,i,t){},"8ee2":function(e,i,t){},b43d:function(e,i,t){"use strict";var n=t("8ee2"),s=t.n(n);s.a},c3d5:function(e,i,t){},e5c3:function(e,i,t){"use strict";var n=t("12b2"),s=t.n(n);s.a},e7b5:function(e,i,t){"use strict";t.r(i);t("e260"),t("e6cf"),t("cca6"),t("a79d");var n=t("2b0e"),s=function(){var e=this,i=e.$createElement,t=e._self._c||i;return t("div",{staticClass:"main"},[t("LoginPanel")],1)},o=[],r=function(){var e=this,i=e.$createElement,t=e._self._c||i;return t("div",{staticClass:"LoginPanelAll"},[t("div",{staticClass:"LoginBack"},[e._m(0),t("div",{staticClass:"LoginPanel"},[t("el-form",{attrs:{model:e.form,rules:e.rules,"label-width":"65px"}},[t("el-form-item",{attrs:{label:"用户名",prop:"username"}},[t("el-input",{attrs:{clearable:"",placeholder:"请输入用户名"},model:{value:e.form.username,callback:function(i){e.$set(e.form,"username",i)},expression:"form.username"}})],1),t("el-form-item",{attrs:{label:"密码",prop:"password"}},[t("el-input",{attrs:{placeholder:"请输入密码","show-password":""},model:{value:e.form.password,callback:function(i){e.$set(e.form,"password",i)},expression:"form.password"}})],1),t("el-form-item",{staticStyle:{display:"flex","justify-content":"right","padding-right":"20px"}},[t("el-switch",{attrs:{"active-text":"我是管理员","inactive-text":"我是用户"},model:{value:e.loginRole,callback:function(i){e.loginRole=i},expression:"loginRole"}})],1),t("div",{staticStyle:{padding:"0 20px"}},[t("input",{staticClass:"CommonButton",attrs:{id:"TextEditButton",type:"button",value:"登录"},on:{click:e.login}})])],1),t("LineWordLine",[e._v("有问题？")]),t("div",{staticClass:"ResetPassword"},[t("el-link",{on:{click:e.retrieveCi}},[e._v("忘记密码")])],1)],1),t("div",{staticClass:"SignInPanel"},[t("span",[e._v("没有账号？")]),t("span",[t("el-link",{attrs:{type:"primary"},on:{click:e.signIn}},[e._v("注册")])],1)])]),t("el-dialog",{attrs:{visible:e.dialogVisible,title:"注册账号",width:"400px"},on:{"update:visible":function(i){e.dialogVisible=i}}},[t("PanelSignIn",{on:{finishSignIn:e.finishSignIn}})],1),t("el-dialog",{attrs:{visible:e.dialogVisible2,title:"邮箱验证",width:"30%"},on:{"update:visible":function(i){e.dialogVisible2=i}}},[t("el-form",{attrs:{model:e.form2,rules:e.rules}},[t("el-form-item",{attrs:{label:"请输入你的注册邮箱",prop:"email"}},[t("el-input",{model:{value:e.form2.email,callback:function(i){e.$set(e.form2,"email",i)},expression:"form2.email"}})],1),t("el-button",{attrs:{type:"primary"},on:{click:e.emailSend}},[e._v("发送验证码")])],1)],1),t("el-dialog",{attrs:{visible:e.dialogVisible3,title:"验证码填写",width:"30%"},on:{"update:visible":function(i){e.dialogVisible3=i}}},[t("el-form",{attrs:{model:e.form2,rules:e.rules}},[t("el-form-item",{attrs:{label:"请输入你收到的验证码"}},[t("el-input",{model:{value:e.form2.code,callback:function(i){e.$set(e.form2,"code",i)},expression:"form2.code"}})],1),t("el-button",{attrs:{type:"primary"},on:{click:e.receiveCode}},[e._v("确定")])],1)],1),t("el-dialog",{attrs:{visible:e.dialogVisible4,title:"重置密码",width:"30%"},on:{"update:visible":function(i){e.dialogVisible4=i}}},[t("el-form",{attrs:{model:e.form2,rules:e.rules}},[t("el-form-item",{attrs:{label:"请输入你的新密码",prop:"password"}},[t("el-input",{model:{value:e.form2.password,callback:function(i){e.$set(e.form2,"password",i)},expression:"form2.password"}})],1),t("el-button",{attrs:{type:"primary"},on:{click:e.rePassword}},[e._v("确定")])],1)],1)],1)},a=[function(){var e=this,i=e.$createElement,n=e._self._c||i;return n("div",{staticClass:"LoginFront"},[n("img",{attrs:{src:t("1b9f")}})])}],l=function(){var e=this,i=e.$createElement,t=e._self._c||i;return t("div",{staticStyle:{width:"100%"}},[e._m(0),t("LineWordLine",[e._v("开始注册")]),t("div",{staticClass:"SignInPanel"},[t("el-form",{attrs:{model:e.signInForm,rules:e.rules}},[t("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[t("el-input",{model:{value:e.signInForm.email,callback:function(i){e.$set(e.signInForm,"email",i)},expression:"signInForm.email"}})],1),t("el-form-item",{attrs:{label:"密码",prop:"password"}},[t("el-input",{attrs:{"show-password":""},model:{value:e.signInForm.password,callback:function(i){e.$set(e.signInForm,"password",i)},expression:"signInForm.password"}})],1),t("el-form-item",{attrs:{label:"昵称",prop:"nickName"}},[t("el-input",{model:{value:e.signInForm.nickName,callback:function(i){e.$set(e.signInForm,"nickName",i)},expression:"signInForm.nickName"}})],1),t("el-form-item",{staticClass:"TwoButton"},[t("el-button",{attrs:{type:"primary"},on:{click:e.success}},[e._v("注册")]),t("el-button",{attrs:{type:"info"},on:{click:e.finish}},[e._v("取消")])],1)],1)],1)],1)},c=[function(){var e=this,i=e.$createElement,n=e._self._c||i;return n("div",{staticClass:"logo"},[n("img",{attrs:{alt:"logo",height:"60px",src:t("1b9f")}})])}],u=t("3cc0"),m={name:"PanelSignIn",data:function(){return{signInForm:{email:"",password:"",nickName:""},rules:{email:[{required:!0,message:"请输入用户名邮箱",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:6,max:28,message:"密码长度在6-18位之间",trigger:"blur"},{pattern:/^[a-zA-Z](\w){5,17}$/,message:"以字母开头，长度在6-18之间， 只能包含字符、数字和下划线"}],nickName:[{required:!0,message:"请输入您的注册昵称",trigger:"blur"}]}}},components:{LineWordLine:u["a"]},methods:{success:function(){var e=this;this.axios.post("http://47.107.77.163:8080/demo/register",{userType:0,email:this.signInForm.email,userName:this.signInForm.nickName,userPwd:this.signInForm.password}).then((function(i){var t=i.data.code;1===t?(e.$emit("finishSignIn"),e.$notify({title:"注册成功",message:"您的账号".concat(e.signInForm.email,"已经完成注册"),type:"success",duration:3500})):e.$notify.error({title:"注册失败",message:"您的账号".concat(e.signInForm.email,"已经被注册"),duration:3500})}))},finish:function(){this.$emit("finishSignIn")}}},d=m,f=(t("b43d"),t("2877")),g=Object(f["a"])(d,l,c,!1,null,"38b77553",null),p=g.exports,b={name:"LoginPanel",data:function(){return{form:{username:"",password:""},form2:{email:"",code:"",password:""},rules:{email:[{required:!0,message:"请输入用户名邮箱",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:"blur"}],username:[{required:!0,message:"请输入用户名邮箱",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:6,max:28,message:"密码长度在6-18位之间",trigger:"blur"},{pattern:/^[a-zA-Z](\w){5,17}$/,message:"以字母开头，长度在6-18之间， 只能包含字符、数字和下划线"}]},loginRole:0,dialogVisible:!1,dialogVisible2:!1,dialogVisible3:!1,dialogVisible4:!1,verCode:0}},components:{PanelSignIn:p,LineWordLine:u["a"]},methods:{login:function(){var e=this,i=this.loginRole?1:0;console.log("login"),this.axios.post("http://47.107.77.163:8080/demo/login",{email:this.form.username,password:this.form.password,userType:i}).then((function(t){console.log(t);var n=t.data.code;if(1===n){var s=t.data.userId;0===i?(window.location.href="./PostPage.html",sessionStorage.setItem("ID",s),sessionStorage.setItem("isFirstLogin",1)):(window.location.href="./AdminPage.html",sessionStorage.setItem("adminId",s))}else 2===n?e.$notify.error({title:"登陆失败",message:"您的账号".concat(e.form.username,"不存在，请点击注册按钮进行注册"),duration:3500}):3===n&&e.$notify.error({title:"登陆失败",message:"您的密码输入错误",duration:3500})}))},finishSignIn:function(){this.dialogVisible=!1},signIn:function(){this.dialogVisible=!0},retrieveCi:function(){this.dialogVisible2=!0},emailSend:function(){var e=this;console.log(this.form2.email),this.axios.get("".concat(this.GLOBAL.apiUrl,"/getVerificationCode"),{params:{emailCode:this.form2.email}}).then((function(i){e.verCode=i.data.verificationCode,e.dialogVisible2=!1,e.dialogVisible3=!0,console.log(i.data.verificationCode),e.$message({message:"验证码已发送",type:"success"})})).catch((function(e){console.log(e)}))},receiveCode:function(){this.verCode==this.form2.code?(this.dialogVisible3=!1,this.dialogVisible4=!0,this.$message({message:"验证码正确",type:"success"})):this.$message({message:"验证码错误",type:"warning"})},rePassword:function(){var e=this;this.axios.get("".concat(this.GLOBAL.apiUrl,"/getVerificationCode"),{params:{emailCode:this.form2.email}}).then((function(i){e.verCode=i.data.verificationCode,e.dialogVisible2=!1,e.dialogVisible3=!0,console.log(i.data.verificationCode),e.$message({message:"验证码已发送",type:"success"}),e.dialogVisible4=!1})).catch((function(e){console.log(e)}))}}},h=b,v=(t("0dfa"),Object(f["a"])(h,r,a,!1,null,"a4f10748",null)),w=v.exports,y={name:"LoginPage",data:function(){return{}},components:{LoginPanel:w}},x=y,I=(t("e5c3"),Object(f["a"])(x,s,o,!1,null,"0e324370",null)),k=I.exports,C=t("5c96"),_=t.n(C),$=(t("0fae"),t("a7fe")),P=t.n($),V=t("bc3a"),L=t.n(V),S=t("d842"),F=t.n(S),O=(t("2ba8"),t("c41d"));n["default"].prototype.$layer=F()(n["default"]),n["default"].prototype.GLOBAL=O["a"],n["default"].config.productionTip=!1,n["default"].use(_.a),n["default"].use(P.a,L.a),new n["default"]({render:function(e){return e(k)}}).$mount("#app")}});
//# sourceMappingURL=index.0877311c.js.map