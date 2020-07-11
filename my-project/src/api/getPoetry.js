import request from '@/utils/request'

export function getPoetry (username) {
  let data = {
    username
  }
  return request({
    url: '/poetryAction/poetry',
    method: 'post',
    data
  })
}

export function getPoetryAll () {
  return request({
    url: '/poetryAction/poetryAll',
    method: 'post'
  })
}

export function getFamousAll () {
  return request({
    url: '/poetryAction/getFamousAll',
    method: 'post'
  })
}

export function getFamous (keyword, type) {
  let data = {
    keyword,
    type
  }
  return request({
    url: '/poetryAction/getFamous',
    method: 'post',
    data
  })
}

export function getMaster () {
  return request({
    url: '/masterAction/master',
    method: 'post'
  })
}

export function search (type, keyword, username) {
  let data = {
    type, keyword, username
  }
  return request({
    url: '/poetryAction/search',
    method: 'post',
    data
  })
}

export function collection (collection, poetryname, username) {
  let data = {
    collection,
    poetryname,
    username
  }
  return request({
    url: '/poetryAction/collection',
    method: 'post',
    data
  })
}
