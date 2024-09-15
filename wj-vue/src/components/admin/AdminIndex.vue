<template>
  <div class="admin-index">
    <el-container id="admin-body">
      <el-header style="z-index: 1;height: 80px;margin-left: -20px">
        <Header style="position: absolute;width: 98%;"></Header>
      </el-header>
      <!--<el-row style="height: 100%;">-->
      <el-container>
        <el-aside style="height: 112%;margin-top: -80px;width: 250px">
          <AdminMenu></AdminMenu>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import AdminMenu from './AdminMenu'
import Header from './Header'

export default {
  name: 'AdminIndex',
  components: {AdminMenu, Header},
  data () {
    return {
      dialogVisible: false
    }
  },
  mounted () {
    // this.$router.replace('/admin/dashboard')
  }
}
</script>

<style scoped>
.admin-index {
  background:url("../../assets/img/bg/fgo_2.1_bg.jpg") no-repeat, center;
  margin: 0;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
#admin-body {
  height: 95vh;
}
</style>
