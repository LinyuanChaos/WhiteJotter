package com.example.wj.service;

import com.example.wj.dao.BookCategoryDAO;
import com.example.wj.pojo.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {
    @Autowired
    BookCategoryDAO bookCategoryDAO;

    public List<BookCategory> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookCategoryDAO.findAll(sort);
    }

    public BookCategory get(int id) {
        BookCategory c= bookCategoryDAO.findById(id).orElse(null);
        return c;
    }
}
