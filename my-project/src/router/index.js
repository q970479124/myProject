import Vue from 'vue'
import Router from 'vue-router'
// import login from '@/view/login'
import index from '@/view/index'
import poetryManage from '@/view/poetryManage'
import websocket from '@/view/websocket'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'websocket',
    component: websocket
  }, {
    path: '/index',
    name: 'index',
    component: index
  }, {
    path: '/poetryManage',
    name: 'poetryManage',
    component: poetryManage
  }]
})
