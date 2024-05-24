package com.example.wj.controller;

import com.example.wj.pojo.User;
import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.AdminUserRoleService;
import com.example.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @CrossOrigin
    @GetMapping("/api/admin/user")
    @ResponseBody
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    @CrossOrigin
    @PutMapping("/api/admin/user/status")
    @ResponseBody
    public Result updateUserStatus(@RequestBody User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    @CrossOrigin
    @PutMapping("/api/admin/user/password")
    @ResponseBody
    public Result resetPassword(@RequestBody User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    @CrossOrigin
    @PutMapping("/api/admin/user")
    @ResponseBody
    public Result editUser(@RequestBody User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }
}
