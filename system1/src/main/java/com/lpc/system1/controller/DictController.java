/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.controller;

import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 字典管理功能的controller实现
 * @CreateTime 2023/2/18-21:54
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 *
 */
@Slf4j
@RestController
@RequestMapping("/admin/dict/")
public class DictController {

    @Resource
    private DictService dictService;

    /**
     * 接收请求后，向前端返回字典管理页面的视图
     * @param view
     * @return
     */
    @GetMapping("/")
    public ModelAndView toDict(ModelAndView view){
        view.setViewName("admin/dict");
        return view;
    }

    /**
     * 接收请求后想前端返回字典类型数据
     * @return
     */
    @ResponseBody
    @PostMapping("/typeList")
    public ResponseMessage typeList(@RequestParam(value = "page")Integer page, @RequestParam("limit")Integer count){
        System.out.println(("page="+page+";limit="+count));
        return dictService.typeList(page,count);
    }
}
