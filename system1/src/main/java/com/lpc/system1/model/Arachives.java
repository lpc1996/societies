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
 * @CreateTime 2023/2/16-22:10
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 * 用户档案信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Arachives extends Model {

    /**
     * 用户ID，与用户表使用同一个ID
     */
    @TableId(type = IdType.NONE)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardNum;

    /**
     * 学历
     */
    private String Education;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
