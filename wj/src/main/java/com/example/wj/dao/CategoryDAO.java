package com.example.wj.dao;

import com.example.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
