import request from '@/utils/request'

export function login (username, password) {
  let data = {
    username: username,
    password: password
  }
  return request({
    url: '/loginAction/login',
    method: 'post',
    data
  })
}
