/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @package: com.example.dataservice.model.response
 * @Author: 旁观者
 * @Date: 2023/2/17-22:21
 * @By: IntelliJ IDEA
 * @FileName: ResponseMessageEnum.java
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseMessageEnum {

    LOGIN_SUCCUSS(2000,"登陆成功，欢迎"),
    LOGIN_FAIL(2001,"登陆失败，用户名或密码错误，请重新输入"),
    NOTFOUND_USERNAME(2002,"找不到用户名，请重新输入正确的用户名"),
    VERIFY_SUCCESS(2003,"验证码正确")
    ,VERIFY_FAIL(2004,"验证码错误，请重新输入")
    ,VERIFY_TIMEOUT(2009,"您输入的验证码已失效，请重新输入")
    ,LOG_WRITE_SUCCESS(2005,"操作日志写入数据库成功")
    ,LOG_WRITE_FAIL(2006,"操作日志写入数据库失败")
    ,LOG_READ_SUCCESS(2007,"操作日志读取成功")
    ,LOG_READ_Fail(2008,"操作日志读取失败")
    ,DICT_TYPE_INSERT_FAIL(2009,"插入字典类型失败，字典类型代码不允许重复")
    ,DICT_VALUE_INSERT_FAIL(2010,"插入字典键值失败，在同一个字典类型下的字典键值必须唯一")
    , REQUEST_SUCCESS(400,"请求成功")
    ,DICT_TYPE_UPDATE_FAIL(2011,"更新字典类型失败")
    ,DICT_TYPE_DELETE_FAIL(2012,"删除字典类型失败，删除字典类型是必须确保该字典类型没有对应的字典键值存在")
    ,DICT_VALUE_UPDATE_FAIL(2013,"更新字典键值失败")
    ,DICT_VALUE_DELETE_FAIL(2014,"删除字典键值失败")
    ,DICT_TYPE_SELECT_FAIL(2015,"查询字典类型失败")
    ,DICT_VALUE_SELECT_FAIL(2016,"查询字典键值失败");

    private Integer code;

    private String message;

}
