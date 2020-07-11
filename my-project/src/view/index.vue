<template>
  <div class="index">
    <div class="index-head">
      <div class="index-head-box">
        <div class="index-head-box-cond">
          <div class="index-head-box-img">
            <img class="index-head-box-img-i" src="../../static/ziti_a.png" />
          </div>
          <div class="index-head-box-tab">
            <div :class="['index-head-box-tab-i',tab === 1?'color-reds':'']" @click="option(1)">推荐</div>
            <div :class="['index-head-box-tab-i',tab === 2?'color-reds':'']" @click="option(2)">古诗</div>
            <div :class="['index-head-box-tab-i',tab === 3?'color-reds':'']" @click="option(3)">作者</div>
            <div :class="['index-head-box-tab-i',tab === 4?'color-reds':'']" @click="option(4)">名句</div>
          </div>
        </div>
        <div class="index-head-box-user">
          <el-avatar> {{ username }} </el-avatar>
        </div>
      </div>
    </div>
    <div class="index-content">
      <div class="index-content-box" v-if="tab===1">
        <searchRecom></searchRecom>
      </div>
      <div class="index-content-box" v-if="tab===2">
        <searchPoetry></searchPoetry>
      </div>
      <div class="index-content-box" v-if="tab===3">
        <searchAuth></searchAuth>
      </div>
      <div class="index-content-box" v-if="tab===4">
        <searchFamous></searchFamous>
      </div>
    </div>
  </div>
</template>
<script>
import searchPoetry from '@/components/searchPoetry/searchPoetry'
import searchFamous from '@/components/searchFamous/searchFamous'
import searchRecom from '@/components/searchRecom/searchRecom'
import searchAuth from '@/components/searchAuth/searchAuth'
export default {
  components: {
    searchPoetry,
    searchFamous,
    searchRecom,
    searchAuth
  },
  data () {
    return {
      username: '',
      tab: 1
    }
  },
  mounted () {
    let user = this.$store.getters.getUsername
    this.username = user.substring(user.length - 3, user.length)
  },
  methods: {
    option (num) {
      this.tab = num
    }
  }
}
</script>
<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/index.css";
</style>
