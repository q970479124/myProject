import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    username: ''
  },
  getters: {
    getUsername: function (state) {
      return state.username
    }
  },
  mutations: {
    setUsername (state, value) {
      state.username = value
    }
  },
  actions: {
    setUsernameAction (context, value) {
      context.commit('setUsername', value)
    }
  }
})

export default store
