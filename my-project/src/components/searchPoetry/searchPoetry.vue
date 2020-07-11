<template>
  <div>
    <div class="index-content-search">
      <el-input placeholder="请输入内容" v-model="keyword">
        <el-select v-model="select" slot="prepend" class="index-content-search-select" placeholder="请选择">
          <el-option v-for="(item, index) in education" :key="index" :label="item.name" :value="item.value"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" @click="searchMethod"></el-button>
      </el-input>
    </div>
    <div class="display-flex">
      <div class="index-content-box-left">
        <el-card class="index-content-box-card" v-for="(item, index) in arr" :key="index">
          <div :class="['index-content-sign', item.username===userId?'color-red':'color-grey']" @click="collection(item)">
            <i class="fa fa-heart"></i>
          </div>
          <div slot="header" class="clearfix">
            {{ item.poetryname }}
          </div>
          <div class="index-content-box-card-auth">作者:{{ item.auth }}</div>
          <div>{{ item.content }}</div>
        </el-card>
        <el-pagination layout="prev, pager, next" :page-size="5" @current-change="change" :total="total"></el-pagination>
      </div>
      <div class="index-content-box-right">
        <el-card class="index-content-box-card-i">
          <div slot="header" class="clearfix">
            <span class="index-content-box-card-color"></span>
            类别
          </div>
          <el-tag v-for="(item, index) in category" :key="index" type="success" size="mini" class="tag-right" @click="condMethod('5',item.category)">
            {{item.category}}
          </el-tag>
        </el-card>
        <el-card class="index-content-box-card-i">
          <div slot="header" class="clearfix">
            <span class="index-content-box-card-color-i"></span>
            作者
          </div>
          <el-tag v-for="(item, index) in auth" :key="index" size="mini" class="tag-right" @click="condMethod('4',item.auth)">{{item.auth}}</el-tag>
        </el-card>
        <el-card class="index-content-box-card-i">
          <div slot="header" class="clearfix">
            <span class="index-content-box-card-color-o"></span>
            朝代
          </div>
          <el-tag v-for="(item, index) in dynasty" :key="index" type="danger" size="mini" class="tag-right" @click="condMethod('2',item.dynasty)">{{item.dynasty}}</el-tag>
        </el-card>
      </div>
    </div>
  </div>
</template>
<script>
import { getPoetry, getMaster, search, collection } from '@/api/getPoetry'
export default {
  data () {
    return {
      userId: '',
      username: '',
      total: 0,
      arr: [],
      index: '1',
      poetry: {},
      auth: {},
      category: {},
      dynasty: {},
      select: '3',
      keyword: '',
      authData: '',
      cateData: '',
      dyData: '',
      tab: 1,
      education: [
        {
          name: '诗名',
          value: '1'
        },
        {
          name: '朝代',
          value: '2'
        },
        {
          name: '内容',
          value: '3'
        },
        {
          name: '作者',
          value: '4'
        },
        {
          name: '分类',
          value: '5'
        }
      ]
    }
  },
  mounted () {
    this.userId = this.$store.getters.getUsername
    this.username = this.userId.substring(this.userId.length - 3, this.userId.length)
    this.init()
  },
  methods: {
    option (num) {
      this.tab = num
    },
    collection (item) {
      let bl = false
      if (item.username === this.userId) {
        bl = false
      } else {
        bl = true
      }
      collection(
        bl,
        item.poetryname,
        this.userId
      ).then(response => {
        if (response.data.state === 0) {
          this.init()
          if (bl) {
            this.$message({
              type: 'success',
              message: item.poetryname + '已收藏'
            })
          } else {
            this.$message({
              type: 'success',
              message: item.poetryname + '已取消收藏'
            })
          }
        } else {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        }
      })
    },
    condMethod (str, cond) {
      search(str, cond, this.userId).then(response => {
        let res = response.data
        if (res.state === 0) {
          this.poetry = res.poetry
          this.total = res.poetry.length
          this.arr = res.poetry.slice(0, 5)
        } else if (res.state === 1) {
          this.$message({
            type: 'warning',
            message: res.message
          })
        } else {
          this.$message({
            type: 'error',
            message: res.message
          })
        }
      })
    },
    searchMethod () {
      search(this.select, this.keyword, this.userId).then(response => {
        let res = response.data
        if (res.state === 0) {
          this.poetry = res.poetry
          this.total = res.poetry.length
          this.arr = res.poetry.slice(0, 5)
        } else if (res.state === 1) {
          this.$message({
            type: 'warning',
            message: res.message
          })
        } else {
          this.$message({
            type: 'error',
            message: res.message
          })
        }
      })
    },
    init () {
      getPoetry(this.userId).then(response => {
        let res = response.data
        if (res.state === 0) {
          this.poetry = res.poetry
          this.total = res.poetry.length
          this.arr = res.poetry.slice(0, 5)
        } else if (res.state === 1) {
          this.$message({
            type: 'warning',
            message: res.message
          })
        } else {
          this.$message({
            type: 'error',
            message: res.message
          })
        }
      })
      getMaster().then(resp => {
        let re = resp.data
        if (re.state === 0) {
          this.auth = re.auth
          this.category = re.category
          this.dynasty = re.dynasty
        } else {
          this.$message({
            type: 'error',
            message: re.message
          })
        }
      })
    },
    change (val) {
      if (val > 1) {
        this.arr = this.poetry.slice((val - 1) * 5, val * 5)
      } else if (val === 1) {
        this.arr = this.poetry.slice(0, 5)
      }
    }
  }
}
</script>
<style scoped>
@import "../../assets/css/common.css";
@import "../../assets/css/index.css";
</style>
