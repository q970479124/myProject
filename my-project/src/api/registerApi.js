import request from '@/utils/request'

export function register (model) {
  let data = {
    username: model.username,
    password: model.password,
    emil: model.emil
  }
  return request({
    url: '/loginAction/register',
    method: 'post',
    data
  })
}
