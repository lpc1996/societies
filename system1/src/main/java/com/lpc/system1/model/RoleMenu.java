package com.lpc.system1.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 角色用户关联表
 * @CreateTime 2023/2/28-21:33
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleMenu extends Model{

    /**
     * 自动生成的自增编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    private Integer roleId;

    /**
     * 权限ID
     */
    private Integer menuId;

    /**
     * 是否删除（用于逻辑删除插件过滤掉已被逻辑删除的数据）
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
