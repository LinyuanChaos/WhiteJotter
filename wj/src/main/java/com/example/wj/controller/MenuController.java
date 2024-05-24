package com.example.wj.controller;

import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    @CrossOrigin
    @GetMapping("/api/menu")
    @ResponseBody
    public Result menu() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
    }

    @CrossOrigin
    @GetMapping("/api/admin/role/menu")
    @ResponseBody
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }
}
