<template>
    <div>
        <el-form size="mini" :inline="true" label-width="40px">
            <el-form-item label="朝代">
                <el-select v-model="dynastySel" placeholder="请选择">
                    <el-option v-for="(item,index) in dynasty" :key="index" :label="item.dynasty" :value="item.dynasty">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="danger" @click="delDynasty">删除</el-button>
            </el-form-item>
        </el-form>
        <el-form size="mini" :inline="true" label-width="40px">
            <el-form-item label="分类">
                <el-select v-model="categorySel" placeholder="请选择">
                    <el-option v-for="(item,index) in category" :key="index" :label="item.category" :value="item.category">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="danger" @click="delCategory">删除</el-button>
            </el-form-item>
        </el-form>
        <el-form size="mini" :inline="true" label-width="40px">
            <el-form-item label="作者">
                <el-select v-model="authSel" placeholder="请选择">
                    <el-option v-for="(item,index) in auth" :key="index" :label="item.auth" :value="item.auth">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="danger" @click="delAuth">删除</el-button>
            </el-form-item>
        </el-form>
        <div>
            <el-input placeholder="请输入内容" v-model="inputAuth">
                <template slot="prepend">作者</template>
                <el-button slot="append" icon="el-icon-search" @click="searchAuth"></el-button>
            </el-input>
            <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%">
              <el-table-column type="index" width="55"></el-table-column>
              <el-table-column prop="auth" label="作者" width="120"></el-table-column>
              <el-table-column prop="dynasty" label="朝代" width="120"></el-table-column>
              <el-table-column prop="description" label="描述" show-overflow-tooltip></el-table-column>
              <el-table-column label="操作" width="60">
                <template slot-scope="scope">
                  <el-button size="mini" @click="handleEdit(scope.$index, scope.row)" icon="el-icon-edit" circle type="primary"></el-button>
                </template>
              </el-table-column>
            </el-table>
        </div>
        <el-dialog title="提示" :visible.sync="show" width="30%" center>
          <el-form size="mini" label-width="40px">
            <el-form-item label="作者">
                <el-input v-model="authName" disabled></el-input>
            </el-form-item>
            <el-form-item class="form-no-inline" label="朝代">
                <el-select v-model="authDynasty" placeholder="请选择">
                    <el-option v-for="(item,index) in dynasty" :key="index" :label="item.dynasty" :value="item.dynasty">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="url">
                  <el-button slot="prepend">C:/image/</el-button>
                </el-input>
            </el-form-item>
            <el-form-item label="描述">
                <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="description">
                </el-input>
            </el-form-item>
        </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="show = !show">取 消</el-button>
            <el-button type="primary" @click="edit">保 存</el-button>
          </span>
        </el-dialog>
    </div>
</template>
<script>
import {getMaster} from '@/api/getPoetry'
import {dynastyDel, categoryDel, authDel, getAuth, editAuth} from '@/api/masterApi'
export default {
  props: {
    active: {
      type: String
    }
  },
  data () {
    return {
      category: {},
      dynasty: {},
      auth: {},
      dynastySel: '',
      categorySel: '',
      authSel: '',
      inputAuth: '',
      tableData: [],
      show: false,
      description: '',
      authDynasty: '',
      authName: '',
      url: ''
    }
  },
  watch: {
    active (val) {
      if (val === '4') {
        this.init()
      }
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    edit () {
      editAuth(this.authName, this.authDynasty, this.url, this.description).then(response => {
        if (response.data.state === 0) {
          this.searchAuth()
          this.$message({
            type: 'success',
            message: '更新成功!'
          })
          this.show = false
        } else {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        }
      })
    },
    handleEdit (index, row) {
      this.show = !this.show
      this.authName = row.auth
      this.authDynasty = row.dynasty
      this.url = row.url.replace('/image/', '')
      this.description = row.description
    },
    init () {
      getMaster().then(response => {
        let re = response.data
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
    delDynasty () {
      dynastyDel(this.dynastySel).then(response => {
        if (response.data.state !== 0) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'success',
            message: '删除成功'
          })
          this.init()
          this.dynastySel = ''
        }
      })
    },
    delCategory () {
      categoryDel(this.categorySel).then(response => {
        if (response.data.state !== 0) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'success',
            message: '删除成功'
          })
          this.init()
          this.categorySel = ''
        }
      })
    },
    delAuth () {
      authDel(this.authSel).then(response => {
        if (response.data.state !== 0) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.$message({
            type: 'success',
            message: '删除成功'
          })
          this.init()
          this.authSel = ''
        }
      })
    },
    searchAuth () {
      getAuth(this.inputAuth).then(response => {
        if (response.data.state !== 0) {
          this.$message({
            type: 'error',
            message: response.data.message
          })
        } else {
          this.tableData = response.data.authList
        }
      })
    }
  }
}
</script>
