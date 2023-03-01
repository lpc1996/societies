/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.config.mybatis_plus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


import java.time.LocalDateTime;

/**
 * @package:com.example.dataservice.config.mybatis_plus
 * @Author:旁观者
 * @Date:2023/2/2-2:03
 * @By:IntelliJ IDEA
 * @FileName:MyMetaObjectHandler.java
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 自动填充功能的实现
     * 在新增和更新数据时对字段进行赋值
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");

        this.strictInsertFill(metaObject, "createAt", Date.class, new Date()); // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "updateAt", Date.class, new Date()); // 起始版本 3.3.3(推荐)
        this.setFieldValByName("deleted",0,metaObject);
    }

    /**
     * 只在更新数据时对数据进行赋值
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("updateAt",new Date(),metaObject);
//        this.strictUpdateFill(metaObject, "updateAt", Date.class, new Date()); // 起始版本 3.3.3(推荐)

    }
}
