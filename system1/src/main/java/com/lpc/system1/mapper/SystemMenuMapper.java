/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lpc.system1.model.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @package:com.example.dataservice.mapper
 * @Author:旁观者
 * @Date:2023/2/1-2:30
 * @By:IntelliJ IDEA
 */

@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);

    SystemMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemMenu record);

    int updateByPrimaryKey(SystemMenu record);

    /**
     * 撤销删除，用于被进行逻辑删除的数据
     */
    int revokeDelete(@Param("begin") Date begin,@Param("end") Date end);

    /**
     * 查询已被逻辑删除的数据
     */
    List<SystemMenu> selectDeleted(@Param("begin") Date begin, @Param("end") Date end);
}