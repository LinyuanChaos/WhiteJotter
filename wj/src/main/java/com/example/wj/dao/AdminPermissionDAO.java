package com.example.wj.dao;

import com.example.wj.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
    List<AdminPermission> findAllByIdIn(List<Integer> ids);
}
