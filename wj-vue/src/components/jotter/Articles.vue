<template>
  <div style="margin-top: 40px">
    <!--<el-button @click="addArticle()">添加文章</el-button>-->
    <div class="articles-area">
      <el-container>
        <el-aside style="width: 200px;margin-top: 20px">
          <switch></switch>
          <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
        </el-aside>
        <el-main>
          <el-card style="text-align: left;width: 95%">
            <div v-for="article in articles" :key="article.id">
              <div style="float:left;width:80%;height: 150px;">
                <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span></router-link>
                <el-divider content-position="left">{{article.articleDate}}</el-divider>
                <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><p>{{article.articleAbstract}}</p></router-link>
              </div>
              <el-image
                style="margin:18px 0 0 30px;width:100px;height: 100px"
                :src="article.articleCover"
                fit="cover"></el-image>
              <el-divider></el-divider>
            </div>
          </el-card>
        </el-main>
      </el-container>
    </div>
    <el-pagination
      background
      layout="total, prev, pager, next, jumper"
      @current-change="handleCurrentChange"
      :page-size="pageSize"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>

import SideMenu from '../jotter/SideMenu.vue'

export default {
  name: 'Articles',
  components: {SideMenu},
  data () {
    return {
      articles: [],
      pageSize: 4,
      total: 0,
      cid: 0
    }
  },
  mounted () {
    this.loadArticles()
  },
  methods: {
    loadArticles () {
      var _this = this
      this.$axios.get('/article/' + this.pageSize + '/1').then(resp => {
        if (resp && resp.data.code === 200) {
          _this.articles = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    },
    handleCurrentChange (page) {
      var _this = this
      if (this.cid === 0) {
        this.$axios.get('/article/' + this.pageSize + '/' + page).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.articles = resp.data.result.content
            _this.total = resp.data.result.totalElements
          }
        })
      } else {
        var url = 'categories/' + this.cid + '/article/' + this.pageSize + '/' + page
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.articles = resp.data.result.content
            _this.total = resp.data.result.totalElements
          }
        })
      }
    },
    listByCategory () {
      var _this = this
      var cid = this.$refs.sideMenu.cid
      var url = 'categories/' + cid + '/article/' + this.pageSize + '/1'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.articles = resp.data.result.content
          _this.total = resp.data.result.totalElements
        }
      })
    }
  }
}
</script>

<style scoped>
.articles-area {
  width: 990px;
  height: 750px;
  margin-left: auto;
  margin-right: auto;
}

.article-link {
  text-decoration: none;
  color: #606266;
}

.article-link:hover {
  color: #409EFF;
}
</style>
