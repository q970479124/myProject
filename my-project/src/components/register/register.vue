<template>
  <div class="register">
    <el-form :model="model" label-width="80px" class="register-form">
      <el-form-item label="用户名:">
        <el-input v-model="model.username"></el-input>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input v-model="model.password" show-password></el-input>
      </el-form-item>
       <el-form-item label="邮箱:">
        <el-input v-model="model.emil"></el-input>
      </el-form-item>
      <el-form-item class="register-group-btn">
        <el-button type="primary" @click="onSubmit">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { register } from '@/api/registerApi'
export default {
  data () {
    return {
      model: {
        username: '',
        password: '',
        emil: ''
      }
    }
  },
  methods: {
    onSubmit () {
      if (this.rules()) {
        register(this.model).then(response => {
          if (response.data.state === 0) {
            this.$message({
              type: 'success',
              message: '注册成功!'
            })
            this.model = []
            this.$emit('closeDial')
          } else {
            this.$message({
              type: 'error',
              message: response.data.message
            })
          }
        })
      }
    },
    rules () {
      if (this.model.username === '' || this.model.username.length < 3) {
        this.$message({
          type: 'error',
          message: '用户名不能为空且长度最短为3位!'
        })
        return false
      } else if (this.model.password === '' || this.model.password.length < 3) {
        this.$message({
          type: 'error',
          message: '密码不能为空且长度最短为3位!'
        })
        return false
      } else {
        return true
      }
    }
  }
}
</script>
<style scoped>
.register{
  width: 100%;
  height: 100%;
}

.register-form{
  padding-right: 30px;
}

.register-group-btn >>> .el-form-item__content{
  margin-left:40px !important;
}
</style>
