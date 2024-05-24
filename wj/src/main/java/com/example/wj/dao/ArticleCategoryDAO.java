package com.example.wj.dao;

import com.example.wj.pojo.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCategoryDAO extends JpaRepository<ArticleCategory, Integer> {
}
