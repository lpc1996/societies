package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @CreateTime 2023/2/28-21:26
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 * 用户角色关联表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleUser extends Model{

    /**
     * 自动生成的自增长编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户Id
     */
    private Long userID;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 是否删除（用于逻辑删除过滤已被逻辑删除的数据
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
