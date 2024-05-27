package com.example.wj.service;

import com.example.wj.dao.JotterArticleDAO;
import com.example.wj.pojo.ArticleCategory;
import com.example.wj.pojo.Book;
import com.example.wj.pojo.BookCategory;
import com.example.wj.pojo.JotterArticle;
import com.example.wj.redis.RedisService;
import com.example.wj.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;
    @Autowired
    RedisService redisService;
    @Autowired
    ArticleCategoryService articleCategoryService;

    public MyPage list(int page, int size) {
        MyPage<JotterArticle> articles;
        String key = "articlepage:" + page;
        Object articlePageCache = redisService.get(key);

        if (articlePageCache == null) {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Page<JotterArticle> articlesInDb = jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
            articles = new MyPage<>(articlesInDb);
            redisService.set(key, articles);
        } else {
            articles = (MyPage<JotterArticle>) articlePageCache;
        }
        return articles;
    }

    public JotterArticle findById(int id) {
        JotterArticle article;
        String key = "article:" + id;
        Object articleCache = redisService.get(key);

        if (articleCache == null) {
            article = jotterArticleDAO.findById(id);
            redisService.set(key, article);
        } else {
            article = (JotterArticle) articleCache;
        }
        return article;
    }

    public MyPage listByCategory(int cid, int page, int size) {
        MyPage<JotterArticle> articles;
        String key = "articlepage:" + page + "cid:" + cid;
        Object articlePageCache = redisService.get(key);
        ArticleCategory articleCategory = articleCategoryService.get(cid);

        if (articlePageCache == null) {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Page<JotterArticle> articlesInDb = jotterArticleDAO.findAllByArticleCategory(articleCategory, PageRequest.of(page, size, sort));
            articles = new MyPage<>(articlesInDb);
            redisService.set(key, articles);
        } else {
            articles = (MyPage<JotterArticle>) articlePageCache;
        }
        return articles;
    }

    public void addOrUpdate(JotterArticle article) {
        jotterArticleDAO.save(article);

        redisService.delete("article:" + article.getId());
        Set<String> keys = redisService.getKeysByPattern("articlepage*");
        redisService.delete(keys);
    }

    public void delete(int id) {
        jotterArticleDAO.deleteById(id);

        redisService.delete("article:" + id);
        Set<String> keys = redisService.getKeysByPattern("articlepage*");
        redisService.delete(keys);
    }
}
