import request from '@/utils/request'

export function dyAdd (dynasty) {
  let data = {
    dynasty
  }
  return request({
    url: '/saveDynastyAction/dyAdd',
    method: 'post',
    data
  })
}

export function cgAdd (category) {
  let data = {
    category
  }
  return request({
    url: '/saveCategoryAction/cgAdd',
    method: 'post',
    data
  })
}

export function authAdd (auth, dynasty, url, description) {
  let data = {
    auth,
    dynasty,
    url,
    description
  }
  return request({
    url: '/saveAuthAction/authAdd',
    method: 'post',
    data
  })
}

export function getDynasty () {
  return request({
    url: '/masterAction/getDynasty',
    method: 'post'
  })
}

export function dynastyDel (dynasty) {
  let data = {
    dynasty
  }
  return request({
    url: '/saveDynastyAction/dynastyDel',
    method: 'post',
    data
  })
}

export function categoryDel (category) {
  let data = {
    category
  }
  return request({
    url: '/saveCategoryAction/categoryDel',
    method: 'post',
    data
  })
}

export function authDel (auth) {
  let data = {
    auth
  }
  return request({
    url: '/saveAuthAction/authDel',
    method: 'post',
    data
  })
}

export function getAuth (auth) {
  let data = {
    auth
  }
  return request({
    url: '/authAction/getAuth',
    method: 'post',
    data
  })
}

export function editAuth (auth, dynasty, url, description) {
  let data = {
    auth,
    dynasty,
    url,
    description
  }
  return request({
    url: '/authAction/editAuth',
    method: 'post',
    data
  })
}
