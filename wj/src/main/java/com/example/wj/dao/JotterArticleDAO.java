package com.example.wj.dao;

import com.example.wj.pojo.ArticleCategory;
import com.example.wj.pojo.JotterArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JotterArticleDAO  extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
    Page<JotterArticle> findAllByArticleCategory(ArticleCategory articleCategory, PageRequest pagerequest);
}
