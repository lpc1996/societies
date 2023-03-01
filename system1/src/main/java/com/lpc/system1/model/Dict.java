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
 * 字典值数据
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Dict extends Model{

    /**
     * 字典编码
     */
    @TableId(type = IdType.AUTO)
    private Integer dictCode;

    /**
     * 字典排序
     */
    private Integer sort;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 是否默认（1：是，0：否）
     */
    private Integer idDefault;

    /**
     * 字典状态
     */
    private Integer status;

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
