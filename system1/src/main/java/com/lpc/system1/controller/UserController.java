package com.lpc.system1.controller;

import com.lpc.system1.model.LoginInfo;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.service.LoginService;
import com.lpc.system1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @CreateTime 2023/2/21-22:21
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    /**
     * 用户登录路由，向前端返回登录页面
     * @param view
     * @return 向前端返回登录页面视图
     */
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public ModelAndView toLogin(ModelAndView view){
        view.setViewName("login");
        return view;
    }

    @PostMapping("/login")
    public ResponseMessage login(LoginInfo info){
        return loginService.login(info);
    }
}
