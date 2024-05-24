package com.example.wj.service;

import com.example.wj.dao.ArticleCategoryDAO;
import com.example.wj.dao.BookCategoryDAO;
import com.example.wj.pojo.ArticleCategory;
import com.example.wj.pojo.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryService {
    @Autowired
    ArticleCategoryDAO articleCategoryDAO;

    public List<ArticleCategory> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return articleCategoryDAO.findAll(sort);
    }

    public ArticleCategory get(int id) {
        ArticleCategory c = articleCategoryDAO.findById(id).orElse(null);
        return c;
    }
}
