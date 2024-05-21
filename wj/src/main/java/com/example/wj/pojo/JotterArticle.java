package com.example.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "jotter_article")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class JotterArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "id 不能为 null")
    private int id;
    @NotEmpty(message = "文章标题不能为空")
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Date articleDate;

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    @NotNull(message = "id 不能为 null")
    public int getId() {
        return id;
    }

    public void setId(@NotNull(message = "id 不能为 null") int id) {
        this.id = id;
    }

    public @NotEmpty(message = "文章标题不能为空") String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(@NotEmpty(message = "文章标题不能为空") String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }
}
