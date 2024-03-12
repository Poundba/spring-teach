package com.example.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.TUser;
import com.example.service.TUserService;
import com.example.utils.MyResult;
import com.example.utils.MyResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private TUserService userService;

//    @PostMapping("/login")
//    public MyResult login(@RequestParam("username") String username,
//                          @RequestParam("password") String password) {
//        TUser user = userService.getOne(new QueryWrapper<TUser>()
//                .eq("username", username)
//                .eq("password", password));
//        if (user != null) {
//            return MyResultBuilder.success("登录成功");
//        } else {
//            return MyResultBuilder.error("登录失败");
//        }
//    }

    @PostMapping("/login")
    public MyResult login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        TUser user = userService.getOne(Wrappers.<TUser>lambdaQuery()
                .eq(TUser::getUsername, username)
                .eq(TUser::getPassword, password));
        if (user != null) {
            return MyResultBuilder.success("登录成功");
        } else {
            return MyResultBuilder.error("登录失败");
        }
    }
}
