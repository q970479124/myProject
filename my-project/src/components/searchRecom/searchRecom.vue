<template>
  <el-row style="width:100%">
    <el-row style="height:100%;">
        <el-card class="search-recom-card" v-for="(item, index) in arr" :key="index">
            <div slot="header" class="clearfix">
                <span>{{item.poetryname}}</span>
            </div>
            <el-row>{{item.auth}}</el-row>
            <el-row>{{item.content}}</el-row>
            <el-row class="search-recom-famous">名句:{{item.famous}}</el-row>
        </el-card>
        <el-pagination layout="prev, pager, next" :page-size="5" @current-change="change" :total="total"></el-pagination>
    </el-row>
  </el-row>
</template>
<script>
import { getPoetryAll } from '@/api/getPoetry'
export default {
  data () {
    return {
      poetry: [],
      arr: [],
      total: 0
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    init () {
      getPoetryAll().then(response => {
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
@import './searchRecom.css';
</style>
