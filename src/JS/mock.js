import Mock from 'mockjs'

let data =
  {
    'user': {
      'name': '@cname',
      'postNum|1-100': 100,
      'fansNum|1-100': 100,
      "followNum|1-100": 100,
      'words': '@ctitle'
    },
    'reportedPosts|16': [
      {
        'title': '@title',
        'id': '@id',
        'postDate': '@date',
        'posterID': '@cname',
        'reportTimes|1-20': 20,
        'content': '@cparagraph'
      }
    ],
    'postItem|5': [
      {
        'id':'@id',
        'content':'@cparagraph'
      }
    ],
    'axisItem|5':[
      {
        "id": '@id',
        "title":"@ctitle",
        "msg":"@csentence",
        "date":"@date",
        "type":"日常",
        "url":"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
      }
    ]
  }
Mock.mock('data/index', 'get', data)