/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;

import java.util.Date;

/**
 * @package:com.example.model
 * @Author:旁观者
 * @Date:2023/2/2-1:21
 * @By:IntelliJ IDEA
 * @FileName:Model.java
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createAt;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    /**
     * 数据版本，乐观锁使用
     */
    @Version
    private Integer version;
}
