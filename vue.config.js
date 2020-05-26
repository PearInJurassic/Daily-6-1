module.exports = {
  pages:{
    'index':{
      entry:'src/pages/LoginPage/main.js',
      template:'src/pages/LoginPage/index.html',
      file:"index.html",
      title:"登录"
    },
    'PostPage' :{
      entry:'src/pages/PostPage/main.js',
      template:'public/index.html',
      file:"postpage.html",
      title:"Daily6+1"
    },
    'AdminPage' :{
      entry:'src/pages/AdminPage/main.js',
      template:'public/index.html',
      file:"adminpage.html",
      title:"Daily6+1 admin"
    }
  },
  configureWebpack: {
    externals: {
      "BMap": "BMap"
    }
  },
  // devServer:{
  //   proxy:'http://localhost:8080'
  // }
}