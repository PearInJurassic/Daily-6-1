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
    }
  }
}