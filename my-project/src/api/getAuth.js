import request from '@/utils/request'

export function getAuthAll () {
  return request({
    url: '/authAction/getAuthAll',
    method: 'post'
  })
}

export function getAuth (keyword, type) {
  let data = {
    keyword,
    type
  }
  return request({
    url: '/authAction/auth',
    method: 'post',
    data
  })
}
