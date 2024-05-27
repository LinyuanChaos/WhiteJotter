<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/admin/content/book'}">内容管理</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/admin/content/article'}">文章管理</el-breadcrumb-item>
        <el-breadcrumb-item>编辑器</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row>
      <el-input
        v-model="article.articleTitle"
        style="margin: 10px 0px;font-size: 18px;"
        placeholder="请输入标题"></el-input>
    </el-row>
    <el-row style="height: calc(100vh - 140px);">
      <mavon-editor
        v-model="article.articleContentMd"
        style="height: 100%;"
        ref=md
        @save="saveArticles"
        fontSize="16px">
        <button type="button" class="op-icon el-icon-document" :title="'摘要/封面'" slot="left-toolbar-after"
                @click="dialogVisible = true"></button>
      </mavon-editor>
      <el-dialog
        :visible.sync="dialogVisible"
        width="30%">
        <el-divider content-position="left">类别</el-divider>
        <el-select v-model="article.articleCategory.id" placeholder="请选择文章类别" clearable="" @change="$forceUpdate()">
          <el-option label="综测" value="1"></el-option>
          <el-option label="奖学金" value="2"></el-option>
          <el-option label="竞赛" value="3"></el-option>
          <el-option label="学术活动" value="4"></el-option>
          <el-option label="文体活动" value="5"></el-option>
          <el-option label="志愿活动" value="6"></el-option>
          <el-option label="其它" value="7"></el-option>
        </el-select>
        <el-divider content-position="left">摘要</el-divider>
        <el-input
          type="textarea"
          v-model="article.articleAbstract"
          rows="6"
          maxlength="255"
          show-word-limit></el-input>
        <el-divider content-position="left">封面</el-divider>
        <div style="margin-top: 20px">
          <el-input v-model="article.articleCover" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload" style="margin-top: 5px"></img-upload>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </span>
      </el-dialog>
    </el-row>
  </div>
</template>

<script>
import ImgUpload from './ImgUpload'

export default {
  name: 'Editor',
  components: {ImgUpload},
  data () {
    return {
      article: {
        articleId: '',
        articleTitle: '',
        articleAbstract: '',
        articleCover: '',
        articleDate: '',
        articleCategory: {
          id: '',
          name: ''
        }
      },
      dialogVisible: false,
      valueSelect: ''
    }
  },
  mounted () {
    if (this.$route.params.article) {
      this.article = this.$route.params.article
    }
  },
  methods: {
    saveArticles (value, render) {
      // value 是 md，render 是 html
      this.$confirm('是否保存并发布文章?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        console.log(this.article)
        this.$axios
          .post('/admin/content/article', {
            id: this.article.id,
            articleTitle: this.article.articleTitle,
            articleContentMd: value,
            articleContentHtml: render,
            articleAbstract: this.article.articleAbstract,
            articleCover: this.article.articleCover,
            articleDate: this.article.articleDate,
            articleCategory: this.article.articleCategory
          }).then(resp => {
            if (resp && resp.data.code === 200) {
              this.$message({
                type: 'info',
                message: '已保存成功'
              })
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消发布'
        })
      })
    },
    uploadImg () {
      this.article.articleCover = this.$refs.imgUpload.url
    }
  }
}
</script>
