// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import 'font-awesome/css/font-awesome.css'

Vue.use(ElementUI)
Vue.config.productionTip = false
/* eslint-disable no-new */

if (sessionStorage.getItem('store')) {
  store.replaceState(
    Object.assign({}, store.state, JSON.parse(sessionStorage.getItem('store')))
  )
  sessionStorage.removeItem('store')
}

window.addEventListener('beforeunload', () => {
  alert(JSON.stringify(store.state))
  sessionStorage.setItem('store', JSON.stringify(store.state))
})
new Vue({
  el: '#app',
  router,
  store,
  components: {
    App
  },
  template: '<App/>'
})
