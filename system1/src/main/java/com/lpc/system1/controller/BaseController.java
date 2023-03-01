package com.lpc.system1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共接口实现,负责默认路由的转发
 * @package:com.example.web.controller
 * @Author:旁观者
 * @Date:2023/2/10-21:37
 * @By:IntelliJ IDEA
 * @FileName:BaseController.java
 */

@Slf4j
@RestController
@RequestMapping("/")
public class BaseController {

    /**
     * 默认的首页
     * @param view
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public ModelAndView welcome(ModelAndView view){
        view.setViewName("index");
        return view;
    }

    @GetMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request,HttpServletResponse response){

    }




}
