package com.hjh.controller;

import com.hjh.dao.UserDao;
import com.hjh.entity.User;
import com.hjh.utils.JWTUtils;
import com.hjh.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;


    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @PostMapping("/user/login")
    public Resp login(@RequestParam String username,
                      @RequestParam String password){
        User user = userDao.login(username, password);
        String token = JWTUtils.getToken(user);
        return Resp.success("success",token);
    }

    /**
     * 根据用户名查询用户是否存在
     * @param username 用户名
     * @return 用户Id
     */
    @GetMapping("/user/findUsername")
    public Resp findUsername(@RequestParam String username){
        Integer userId = userDao.findUsername(username);
        return Resp.success("success",userId);
    }

    /**
     * 通过用户名更新密码
     * @param newPassword 新密码
     * @param username 用户名
     * @return 更新了几行数据
     */
    @PostMapping("/user/resetPassword")
    public Resp resetPassword(@RequestParam String newPassword,
                              @RequestParam String username){
        Integer i = userDao.resetPassword(newPassword, username);
        return Resp.success("success",i);
    }

}
