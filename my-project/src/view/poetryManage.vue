<template>
  <div class="index">
    <div class="index-head">
      <div class="index-head-box">
        <div class="index-head-box-cond">
          <div class="index-head-box-img">
            <img class="index-head-box-img-i" src="../../static/ziti_a.png" />
          </div>
        </div>
        <div class="index-head-box-user">
          <el-avatar> 管理员 </el-avatar>
        </div>
      </div>
    </div>
    <div class="index-content">
      <div class="index-content-box">
        <div class="manage-form">
          <el-tabs v-model="activeName">
            <el-tab-pane label="古诗词新增" name="1">
              <poetryAdd></poetryAdd>
            </el-tab-pane>
            <el-tab-pane label="古诗词修改/删除" name="2">
                <poetryDel></poetryDel>
            </el-tab-pane>
            <el-tab-pane label="作者/朝代/分类新增" name="3">
                <masterAdd></masterAdd>
            </el-tab-pane>
            <el-tab-pane label="作者 朝代 分类修改/删除" name="4">
                <masterDel :active = activeName></masterDel>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import poetryAdd from '@/components/poetry/poetryAdd'
import poetryDel from '@/components/poetry/poetryDel'
import masterAdd from '@/components/poetry/masterAdd'
import masterDel from '@/components/poetry/masterDel'
export default {
  components: {
    poetryAdd,
    poetryDel,
    masterAdd,
    masterDel
  },
  data () {
    return {
      activeName: '1',
      form: {}
    }
  },
  methods: {
    handleChange (val) {
      console.log(val)
    }
  }
}
</script>
<style scoped>
@import "../assets/css/index.css";
.manage-form {
  width: 100%;
  height: 100%;
  margin-top: 10px;
  padding: 15px 50px;
  background-color: #fff;
}
</style>
