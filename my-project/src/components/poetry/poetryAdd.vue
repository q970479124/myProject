<template>
  <div>
    <h2>古诗词</h2>
    <el-form size="mini" label-width="80px">
      <el-form-item label="诗名:">
        <el-input v-model="poetryArr.poetryname"></el-input>
      </el-form-item>
      <el-form-item class="form-no-inline" label="作者:">
        <el-select v-model="poetryArr.auth" placeholder="请选择">
          <el-option v-for="item in auth" :key="item.auth" :label="item.auth" :value="item.auth">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item class="form-no-inline" label="分类:">
        <el-select v-model="poetryArr.category" placeholder="请选择">
          <el-option v-for="item in category" :key="item.category" :label="item.category" :value="item.category">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="名句:">
        <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="poetryArr.famous">
        </el-input>
      </el-form-item>
      <el-form-item label="内容:">
        <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="poetryArr.content">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="savePoetry">新增</el-button>
        <el-button @click="clear">清空</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {getMaster} from '@/api/getPoetry'
import {addPoetry} from '@/api/poetryApi'
export default {
  data () {
    return {
      options: [],
      textarea: '',
      auth: [],
      category: [],
      poetryArr: {
        auth: '',
        category: '',
        content: '',
        poetryname: '',
        famous: ''
      }
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    init () {
      getMaster().then(response => {
        let re = response.data
        if (re.state === 0) {
          this.auth = re.auth
          this.category = re.category
        } else {
          this.$message({
            type: 'error',
            message: re.message
          })
        }
      })
    },
    savePoetry () {
      addPoetry(this.poetryArr).then(response => {
        if (response.data.state === 0) {
          this.$message({
            type: 'success',
            message: '保存成功'
          })
          this.poetryArr.poetryname = ''
          this.poetryArr.auth = ''
          this.poetryArr.content = ''
          this.poetryArr.famous = ''
          this.poetryArr.category = ''
        } else if (response.data.state === 1) {
          this.$message({
            type: 'warning',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        }
      })
    },
    clear () {
      this.poetryArr.poetryname = ''
      this.poetryArr.auth = ''
      this.poetryArr.content = ''
      this.poetryArr.category = ''
      this.poetryArr.famous = ''
    }
  }
}
</script>
<style scoped>
@import '../../assets/css/common.css';
</style>
