<template>
  <div>
    <div class="delete-poetry">
      <el-input v-model="keyword" placeholder="请输入内容">
        <template slot="prepend">
          <el-select v-model="condition" slot="prepend" placeholder="请选择">
            <el-option label="诗名" value="1"></el-option>
            <el-option label="朝代" value="2"></el-option>
            <el-option label="内容" value="3"></el-option>
            <el-option label="作者" value="4"></el-option>
            <el-option label="分类" value="5"></el-option>
          </el-select>
        </template>
        <el-button @click="searchs" slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </div>
    <div>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column label="诗名" prop="poetryname" show-overflow-tooltip width="160"></el-table-column>
        <el-table-column label="作者" prop="auth" width="80"></el-table-column>
        <el-table-column label="朝代" prop="dynasty" width="60"></el-table-column>
        <el-table-column label="分类" prop="category" width="60"></el-table-column>
        <el-table-column label="名句" prop="famous" show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)" icon="el-icon-edit" circle type="primary"></el-button>
            <el-button size="mini" @click="handleDel(scope.$index, scope.row)" icon="el-icon-delete" circle type="error"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog :visible.sync="editShow" :title="poetry.poetryname" width="30%">
      <el-form size="mini" label-width="50px">
        <el-form-item label="诗名:">
          <el-input v-model="poetry.poetryname"></el-input>
        </el-form-item>
        <el-form-item class="form-no-inline" label="作者:">
          <el-select v-model="poetry.auth" placeholder="请选择">
            <el-option v-for="item in auth" :key="item.auth" :label="item.auth" :value="item.auth">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="form-no-inline" label="分类:">
          <el-select v-model="poetry.category" placeholder="请选择">
            <el-option v-for="item in category" :key="item.category" :label="item.category" :value="item.category">
           </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="form-no-inline" label="朝代:">
          <el-select v-model="poetry.dynasty" placeholder="请选择" :disabled="true">
            <el-option v-for="item in dynasty" :key="item.dynasty" :label="item.dynasty" :value="item.dynasty">
           </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="名句:">
          <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="poetry.famous">
          </el-input>
        </el-form-item>
        <el-form-item label="内容:">
          <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="poetry.content">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="edit">保存</el-button>
          <el-button @click="clear">清空</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
import { search, getMaster } from '@/api/getPoetry'
import { delPoetry, editPoetry } from '@/api/poetryApi'
export default {
  data () {
    return {
      editShow: false,
      condition: '1',
      keyword: '',
      tableData: [],
      auth: [],
      category: [],
      dynasty: [],
      poetry: {
        id: '',
        poetryname: '',
        auth: '',
        content: '',
        famous: '',
        dynasty: '',
        category: ''
      }
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    edit () {
      editPoetry(this.poetry).then(resp => {
        if (resp.data.state === 0) {
          this.$message({
            type: 'success',
            message: '修改成功!'
          })
          this.editShow = false
          this.searchs()
        } else {
          this.$message({
            type: 'error',
            message: resp.data.message
          })
        }
      })
    },
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
    handleDel (index, row) {
      delPoetry(row.poetryname, row.auth).then(response => {
        if (response.data.state === 0) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.searchs()
        } else {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        }
      })
    },
    handleEdit (index, row) {
      this.editShow = true
      this.poetry = JSON.parse(JSON.stringify(row))
    },
    clear () {
      this.poetry.poetryname = ''
      this.poetry.auth = ''
      this.poetry.content = ''
      this.poetry.famous = ''
      this.poetry.dynasty = ''
      this.poetry.category = ''
    },
    searchs () {
      search(this.condition, this.keyword).then(response => {
        if (response.data.state === 0) {
          this.tableData = response.data.poetry
        } else if (response.data.state === 1) {
          this.$message({
            type: 'warning',
            message: response.data.message
          })
          this.tableData = []
        } else {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        }
      })
    }
  }
}
</script>
<style scoped>
@import '../../assets/css/common.css';
.delete-poetry >>> .el-select {
  width: 100px;
}
</style>
