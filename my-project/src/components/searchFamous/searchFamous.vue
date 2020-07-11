<template>
  <el-row style="width: 100%;">
    <el-col>
      <div class="search-famous">
        <el-input placeholder="请输入内容" v-model="keyword">
          <el-select v-model="select" class="search-famous-prepend" slot="prepend" placeholder="请选择">
            <el-option v-for="(item, index) in education" :key="index" :label="item.name" :value="item.value"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search" @click="searchMethod"></el-button>
        </el-input>
      </div>
    </el-col>
    <el-col class="search-famous-background" v-for="(item,index) in arr" :key="index">
      <el-row class="search-famous-poetry-name">{{ item.poetryname }}</el-row>
      <el-row>{{ item.famous }}</el-row>
      <el-row class="search-famous-auth">
        <el-col class="search-famous-flex" :span="6" :offset="18">
          <div class="line"></div>
          <div>{{ item.auth }}</div>
        </el-col>
      </el-row>
    </el-col>
    <el-col>
      <el-pagination layout="prev, pager, next" :page-size="10" @current-change="change" :total="total"></el-pagination>
    </el-col>
  </el-row>
</template>
<script>
import { getFamousAll, getFamous } from '@/api/getPoetry'
export default {
  data () {
    return {
      total: 0,
      arr: [],
      famousArr: [],
      count: 0,
      keyword: '',
      select: '1',
      education: [{
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
      } ]
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    searchMethod () {
      getFamous(this.keyword, this.select).then(resp => {
        if (resp.data.state === 0) {
          this.famousArr = resp.data.famous
          this.total = resp.data.famous.length
          this.arr = resp.data.famous.slice(0, 10)
        } else if (resp.data.state === 1) {
          this.$message({
            type: 'warning',
            message: resp.data.message
          })
        } else {
          this.$message({
            type: 'error',
            message: resp.data.message
          })
        }
      })
    },
    load () {
      this.count += 4
    },
    init () {
      getFamousAll().then(resp => {
        if (resp.data.state === 0) {
          this.famousArr = resp.data.famous
          this.total = resp.data.famous.length
          this.arr = resp.data.famous.slice(0, 10)
        } else if (resp.data.state === 1) {
          this.$message({
            type: 'warning',
            message: resp.data.message
          })
        } else {
          this.$message({
            type: 'error',
            message: resp.data.message
          })
        }
      })
    },
    change (val) {
      if (val > 1) {
        this.arr = this.famousArr.slice((val - 1) * 10, val * 10)
      } else if (val === 1) {
        this.arr = this.famousArr.slice(0, 10)
      }
    }
  }
}
</script>
<style scoped>
@import './searchFamous.css';
</style>
