package com.example.wj.dao;

import com.example.wj.pojo.Book;
import com.example.wj.pojo.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByBookCategory(BookCategory bookCategory);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
