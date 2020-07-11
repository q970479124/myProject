import request from '@/utils/request'

export function addPoetry (poetryArr) {
  let data = {
    poetryname: poetryArr.poetryname,
    auth: poetryArr.auth,
    content: poetryArr.content,
    famous: poetryArr.famous,
    category: poetryArr.category
  }
  return request({
    url: '/savePoetryAction/savePoetry',
    method: 'post',
    data
  })
}

export function delPoetry (poetryname, auth) {
  let data = {
    poetryname,
    auth
  }
  return request({
    url: '/savePoetryAction/delPoetry',
    method: 'post',
    data
  })
}

export function editPoetry (poetry) {
  let data = {
    id: poetry.id,
    poetryname: poetry.poetryname,
    auth: poetry.auth,
    content: poetry.content,
    famous: poetry.famous,
    dynasty: poetry.dynasty,
    category: poetry.category
  }
  return request({
    url: '/savePoetryAction/editPoetry',
    method: 'post',
    data
  })
}
