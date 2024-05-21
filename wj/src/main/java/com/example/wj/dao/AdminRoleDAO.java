package com.example.wj.dao;

import com.example.wj.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
