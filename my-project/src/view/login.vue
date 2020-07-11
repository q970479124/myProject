<template>
  <div id="login">
    <div class="login-box">
      <div class="login-title">古诗词学习系统</div>
      <div class="login-register" @click="open = !open">注册</div>
      <div class="login-margin">
        <el-input v-model="username" placeholder="请输入用户名">
          <template slot="prepend">
            <i class="el-icon-user"></i>
          </template>
        </el-input>
      </div>
      <div class="login-margin">
        <el-input v-model="password" placeholder="请输入密码" show-password>
          <template slot="prepend">
            <i class="el-icon-key"></i>
          </template>
        </el-input>
      </div>
      <el-button type="primary" class="login-button login-margin" @click="login">登录</el-button>
    </div>
    <el-dialog ref="dial" :visible.sync="open" width="30%" title="注册">
      <register @closeDial="closeDial"></register>
    </el-dialog>
  </div>
</template>
<script>
import { login } from '@/api/loginApi'
import register from '@/components/register/register'
export default {
  components: {register},
  data () {
    return {
      username: '',
      password: '',
      open: false
    }
  },
  mounted () {
    let _this = this
    document.onkeydown = function (e) {
      if (e.keyCode === 13) {
        _this.login()
      }
    }
  },
  methods: {
    closeDial () {
      this.open = !this.open
    },
    login () {
      if (this.username === '') {
        this.$message({
          type: 'error',
          message: '请输入用户名！'
        })
      } else if (this.password === '') {
        this.$message({
          type: 'error',
          message: '请输入密码！'
        })
      } else {
        login(this.username, this.password).then(response => {
          let res = response.data
          if (res.state === -1) {
            this.$message({
              type: 'error',
              message: res.message
            })
          } else {
            this.$store.dispatch('setUsernameAction', this.username)
            if (res.authority === 1) {
              this.$router.push({path: '/index'})
            } else {
              this.$router.push({path: '/poetryManage'})
            }
          }
        })
      }
    }
  }
}
</script>
<style scoped>
@import "../assets/css/login.css";
</style>
