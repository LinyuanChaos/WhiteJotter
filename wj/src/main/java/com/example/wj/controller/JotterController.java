package com.example.wj.controller;

import com.example.wj.pojo.JotterArticle;
import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.JotterArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;

    @CrossOrigin
    @PostMapping("api/admin/content/article")
    @ResponseBody
    public Result saveArticle(@RequestBody @Valid JotterArticle article) {
        jotterArticleService.addOrUpdate(article);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    @CrossOrigin
    @GetMapping("/api/article/{size}/{page}")
    @ResponseBody
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(jotterArticleService.list(page - 1, size));
    }

    @CrossOrigin
    @GetMapping("/api/article/{id}")
    @ResponseBody
    public Result getOneArticle(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(jotterArticleService.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/api/admin/content/article/{id}")
    @ResponseBody
    public Result deleteArticle(@PathVariable("id") int id) {
        jotterArticleService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
