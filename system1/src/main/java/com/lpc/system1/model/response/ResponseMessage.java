/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.model.response;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
 * @package: com.example.web.model.response
 * @Author: 旁观者
 * @Date: 2023/2/17-22:40
 * @By: IntelliJ IDEA
 * @FileName: ResponeMessage.java
 */

@Data
@AllArgsConstructor(staticName = "newInstancec")
public class ResponseMessage implements Serializable {

    //状态代码
    private Integer code;

    //提示消息
    private String message;

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 总页数
     */
    private Integer total;

    //返回数据
    private Object data;

    private ResponseMessage(ResponseMessageEnum responseMessageEnum, Object data){
        this(responseMessageEnum.getCode(),responseMessageEnum.getMessage(),null,null,data);
    }
    private ResponseMessage(ResponseMessageEnum responseMessageEnum){
        this(responseMessageEnum,null);
    }

    private ResponseMessage(Integer code,String message){
        this(code,message,null,null,null);
    }

    private ResponseMessage(ResponseMessageEnum responseMessageEnum,Integer page,Integer count,Object data){
        this(responseMessageEnum.getCode(),responseMessageEnum.getMessage(),page,count,data);
    }

    public static ResponseMessage newInstances(ResponseMessageEnum responseMessageEnum,Integer page,Integer count,Object data){
        return newInstancec(responseMessageEnum.getCode(),responseMessageEnum.getMessage(),page,count,data);
    }

    public static ResponseMessage newInstancec(ResponseMessageEnum responseMessageEnum,Object data){
        return newInstancec(responseMessageEnum.getCode(),responseMessageEnum.getMessage(),null,null,data);
    }

    public static ResponseMessage newInstancec(ResponseMessageEnum responseMessageEnum){
        return newInstancec(responseMessageEnum,null);
    }

    public static ResponseMessage newInstancec(Integer code,String message){
        return newInstancec(code,message,null,null,null);
    }

    public static String toJsonString(ResponseMessage responseMessage){
        return JSONUtil.toJsonStr(responseMessage);
    }
}
