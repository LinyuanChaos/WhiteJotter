package com.example.wj.controller;

import com.example.wj.pojo.Book;
import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.BookService;

import com.example.wj.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.io.File;
import java.io.IOException;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    @ResponseBody
    public Result listBooks() {
        return ResultFactory.buildSuccessResult(bookService.list());
    }

    @CrossOrigin
    @PostMapping("/api/admin/content/books")
    @ResponseBody
    public Result addOrUpdateBooks(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    @CrossOrigin
    @PostMapping("/api/admin/content/books/delete")
    @ResponseBody
    public Result deleteBook(@RequestBody Book book) {
        bookService.deleteById(book.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @CrossOrigin
    @GetMapping("/api/search")
    @ResponseBody
    public Result searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(bookService.list());
        } else {
            return ResultFactory.buildSuccessResult(bookService.Search(keywords));
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    @ResponseBody
    public Result listByCategory(@PathVariable("cid") int cid) {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(bookService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(bookService.list());
        }
    }

    @CrossOrigin
    @PostMapping("/api/admin/content/books/covers")
    @ResponseBody
    public String coversUpload(MultipartFile file) {
        String folder = "D:/WhiteJotter/wj-vue/src/assets/img/cover";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
