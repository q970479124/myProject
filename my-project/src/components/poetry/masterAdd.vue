<template>
    <div>
        <h2>朝代</h2>
        <el-form size="mini" label-width="40px">
            <el-form-item label="朝代">
                <el-input v-model="dynasty"></el-input>
            </el-form-item>
            <el-form-item class="form-no-margin">
                <el-button type="primary" @click="onDySubmit">新增</el-button>
            </el-form-item>
        </el-form>
        <h2>分类</h2>
        <el-form size="mini" label-width="40px">
            <el-form-item label="分类">
                <el-input v-model="category"></el-input>
            </el-form-item>
            <el-form-item class="form-no-margin">
                <el-button type="primary" @click="onCgSubmit">新增</el-button>
            </el-form-item>
        </el-form>
        <h2>作者</h2>
        <el-form size="mini" label-width="40px">
            <el-form-item label="作者">
                <el-input v-model="auth"></el-input>
            </el-form-item>
            <el-form-item class="form-no-inline" label="朝代">
                <el-select v-model="authDynasty" placeholder="请选择">
                    <el-option v-for="(item,index) in dyList" :key="index" :label="item.dynasty" :value="item.dynasty">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="url">
                  <el-button slot="prepend">C:/image/</el-button>
                </el-input>
            </el-form-item>
            <el-form-item label="描述">
                <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="description">
                </el-input>
            </el-form-item>
            <el-form-item class="form-no-margin">
                <el-button type="primary" @click="onAuthSubmit">新增</el-button>
                <el-button @click="clear">清空</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import {dyAdd, cgAdd, authAdd, getDynasty} from '@/api/masterApi'
export default {
  data () {
    return {
      dynasty: '',
      category: '',
      auth: '',
      url: '',
      description: '',
      authDynasty: '',
      dyList: {},
      message: '保存成功！'
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    init () {
      getDynasty().then(response => {
        if (response.data.state === -1) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.dyList = response.data.dynasty
        }
      })
    },
    clear () {
      this.auth = ''
      this.description = ''
      this.authDynasty = ''
    },
    onDySubmit () {
      dyAdd(this.dynasty).then(response => {
        if (response.data.state === -1) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
          this.dynasty = ''
        } else {
          this.$message({
            type: 'success',
            message: this.message
          })
        }
      })
    },
    onCgSubmit () {
      cgAdd(this.category).then(response => {
        if (response.data.state === -1) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'success',
            message: this.message
          })
        }
      })
    },
    onAuthSubmit () {
      authAdd(this.auth, this.authDynasty, this.url, this.description).then(response => {
        if (response.data.state === -1) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'success',
            message: this.message
          })
        }
      })
    }
  }
}
</script>
<style scoped>
@import '../../assets/css/common.css'
</style>
