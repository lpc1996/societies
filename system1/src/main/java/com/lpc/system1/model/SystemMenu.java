/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @package:com.example.model
 * @Author:旁观者
 * @Date:2023/2/1-2:30
 * @By:IntelliJ IDEA
 * 系统菜单表
 */
@Data
@TableName(value = "system_Menu")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SystemMenu extends Model{
    /**
    * ID
    */
    @TableId(type=IdType.AUTO)
    private Integer id;

    /**
    * 父ID
    */
    private Integer pid;

    /**
    * 名称
    */
    private String title;

    /**
    * 菜单图标
    */
    private String icon;

    /**
    * 链接
    */
    private String href;

    /**
    * 链接打开方式
    */
    private String target;

    /**
    * 菜单排序
    */
    private Integer sort;

    /**
    * 状态(0:禁用,1:启用)
    */
    private Byte status;

    /**
    * 备注信息
    */
    private String remark;

    /**
     * 删除时间
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

}