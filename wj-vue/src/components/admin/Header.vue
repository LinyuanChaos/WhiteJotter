<template>
  <el-card class="admin-header">
    <a href="/index">
      <img src="../../assets/img/icon/cat.png" alt="" width="50px" style="float: left">
    </a>
    <span style="font-size: 20px;font-weight: bold;position:absolute;left: 75px">WhiteJotter后台</span>
    <i class="el-icon-switch-button" v-on:click="logout" style="font-size: 40px;float: right"></i>
  </el-card>
</template>

<script>
import {createRouter} from '../../router'

export default {
  name: 'Header',
  methods: {
    logout () {
      var _this = this
      this.$axios.get('/logout').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.$store.commit('logout')
          _this.$router.replace('/index')
          // 清空路由，防止路由重复加载
          const newRouter = createRouter()
          _this.$router.matcher = newRouter.matcher
        }
      }).catch(failResponse => {})
    }
  }
}
</script>

<style scoped>
.admin-header {
  height: 80px;
  opacity: 0.85;
  line-height: 40px;
  min-width: 900px;
}
.el-icon-switch-button {
  cursor: pointer;
  outline:0;
}
</style>
