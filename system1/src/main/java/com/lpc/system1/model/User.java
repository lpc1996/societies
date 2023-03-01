/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * user
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User extends Model {
    /**
     * 登录信息唯一Id,对于用户自身基本不可见，由系统自动生成
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名,同时也是用户登录名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 用户登录密码
     */
    @TableField(value = "pass")
    private String pass;

    /**
     * 用户类型（0：Boos端（管理员端 一般是老师/工作人员)；1：学生端；2：主席端（宣传部））
     */
    @TableField(value = "u_type")
    private String uType;

    /**
     * 最后一次登录时间
     */
    @TableField(value = "last_login_date")
    private Date lastLoginDate;

    /**
     * 字段是否删除，用于逻辑删除使用，对用户不可见
     */
    @TableLogic
    @TableField(value = "deleted",fill = FieldFill.UPDATE)
    private Integer deleted;
}