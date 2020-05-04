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
    ]
  }
Mock.mock('data/index', 'get', data)