package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @CreateTime 2023/2/28-21:16
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends Model{

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String remark;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
