<template>
  <div>
    <body>
      <el-carousel :height="bannerHeight + 'px'">
        <el-carousel-item v-for="item in carouselImg" :key="item.src">
          <img :src="item">
        </el-carousel-item>
      </el-carousel>
    </body>
    <body id="welcome">
      <el-card class="box-card" style="background-color: rgba(255,255,255,0.5); width: 1000px; height: 100px;">
       <div style="font-size: 42px">
         Welcome to SSE 学生管理平台
       </div>
      </el-card>
    </body>
  </div>
</template>

<script>
export default {
  name: 'AppIndex',
  data () {
    return {
      carouselImg: [
        require('../../assets/img/bg/sys_south.jpg'),
        require('../../assets/img/bg/hst_motto.jpg'),
        require('../../assets/img/bg/tqzx.jpg'),
        require('../../assets/img/bg/building_zh.jpg'),
        require('../../assets/img/bg/lib_zh.jpg')
      ],
      bannerHeight: 0,
      screenWidth: 0
    }
  },
  mounted () {
    // 首次加载时,初始化高度
    this.screenWidth = window.innerWidth
    this.bannerHeight = 700 / 1550 * this.screenWidth
    // 窗口大小发生改变
    window.onresize = () => {
      this.screenWidth = window.innerWidth
      this.bannerHeight = 700 / 1550 * this.screenWidth
    }
  }
}
</script>

<style scoped>

#welcome {
  position: absolute;
  right: 250px;
  top: 300px;
  z-index: 10;
}

img {
  width: 100%;
  height: inherit;
}

body {
  margin: 0;
}

</style>
