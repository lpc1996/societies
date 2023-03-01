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
 * @CreateTime 2023/2/16-22:54
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 * 字典类型数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictType extends Model{

    /**
     * 字典类型表主键
     */
    @TableId(type = IdType.AUTO)
    private Integer dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典状态（1：正常，0：停用）
     */
    private Integer dictStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 字段是否删除，用于逻辑删除使用，对用户不可见
     */
    @TableLogic
    @TableField(value = "deleted",fill = FieldFill.UPDATE)
    private Integer deleted;
}
