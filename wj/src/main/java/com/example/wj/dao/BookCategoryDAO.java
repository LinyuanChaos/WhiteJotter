package com.example.wj.dao;

import com.example.wj.pojo.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryDAO extends JpaRepository<BookCategory, Integer> {
}
