<template>
  <el-row style="width:100%;">
    <div class="search-auth">
      <el-input placeholder="请输入内容" v-model="keyword">
        <el-select v-model="select" class="search-famous-prepend" slot="prepend" placeholder="请选择">
          <el-option v-for="(item, index) in education" :key="index" :label="item.name" :value="item.value"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" @click="searchMethod"></el-button>
      </el-input>
    </div>
    <el-col :span="16">
    <el-card class="search-auth-card" v-for="(item, index) in arr" :key="index">
      <div class="search-auth-img">
        <img :src="http+item.url">
      </div>
      <p class="search-auth-p">{{item.auth}}</p>
      <p>{{item.description}}</p>
    </el-card>
    <el-pagination layout="prev, pager, next" :page-size="5" @current-change="change" :total="total"></el-pagination>
    </el-col>
    <el-col :span="8">
        <el-card class="search-auth-box">
          <div slot="header" class="clearfix">
            <span class="search-auth-box-color"></span>
            作者
          </div>
          <el-tag v-for="(item, index) in authList" :key="index" size="mini" class="tag-right" @click="clickAuth('1',item.auth)">{{item.auth}}</el-tag>
        </el-card>
    </el-col>
  </el-row>
</template>
<script>
import { getAuthAll, getAuth } from '@/api/getAuth'
export default {
  data () {
    return {
      total: 0,
      arr: [],
      http: '',
      authArr: [],
      authList: [],
      keyword: '',
      select: '1',
      education: [
        {
          name: '作者',
          value: '1'
        },
        {
          name: '朝代',
          value: '2'
        } ]
    }
  },
  mounted () {
    this.http = window.location.protocol + '//' + window.location.host
    this.init()
  },
  methods: {
    clickAuth (type, item) {
      getAuth(item, type).then(resp => {
        if (resp.data.state === 0) {
          this.authArr = resp.data.authList
          this.total = resp.data.authList.length
          this.arr = resp.data.authList.slice(0, 5)
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
    searchMethod () {
      getAuth(this.keyword, this.select).then(resp => {
        if (resp.data.state === 0) {
          this.authArr = resp.data.authList
          this.total = resp.data.authList.length
          this.arr = resp.data.authList.slice(0, 5)
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
    init () {
      getAuthAll().then(resp => {
        if (resp.data.state === 0) {
          this.authArr = resp.data.authList
          this.authList = resp.data.authList
          this.total = resp.data.authList.length
          this.arr = resp.data.authList.slice(0, 5)
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
        this.arr = this.authArr.slice((val - 1) * 5, val * 5)
      } else if (val === 1) {
        this.arr = this.authArr.slice(0, 5)
      }
    }
  }
}
</script>
<style scoped>
@import "../../assets/css/index.css";
.search-auth-card {
  margin: 10px 0;
}
.search-auth-img {
  float: left;
  margin-bottom: 15px;
  margin-right: 15px;
  width: 105px;
  height: 150px;
  background-color: blueviolet;
}
.search-auth-p {
  margin: 0;
  color: #19537d;
  font-weight: bold;
  font-size: 18px;
}
.search-auth {
  margin: 10px 0 5px 0;
}
.search-auth >>> .el-input-group__prepend {
  width: 40px;
}
.search-auth-box{
    margin: 10px 0px 0px 20px;
}
.search-auth-box >>> .el-card__header{
    padding: 5px 10px;
    font-size: 18px;
    font-weight: 700;
    color: #6270a0;
    text-align: left;
}
.search-auth-box >>> .el-card__body{
    padding: 5px 10px 20px;
    text-align: left;
}
.search-auth-box-color{
    padding: 4px 5px;
    background-color: #a574a3;
    margin-right: 5px;
}
</style>
