/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.service.impl;

import cn.hutool.core.date.DateUtil;
import com.lpc.system1.mapper.SystemMenuMapper;
import com.lpc.system1.model.SystemMenu;
import com.lpc.system1.service.SystemMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class SystemMenuServiceImpl implements SystemMenuService {

    @Resource
    SystemMenuMapper systemMenuMapper;

    @Override
    public boolean add(SystemMenu menu) {

        return systemMenuMapper.insert(menu) == 1;
    }

    /**
     * 修改菜单
     *
     * @param menu
     */
    @Override
    public boolean update(SystemMenu menu) {
        return systemMenuMapper.updateById(menu) == 1;
    }

    /**
     * 根据菜单Id查询菜单
     *
     * @param menuId
     * @return
     */
    @Override
    public SystemMenu selectById(Integer menuId) {
        return systemMenuMapper.selectById(menuId);
    }

    /**
     * 撤销逻辑删除
     *
     * @param days 设定在days天之内删除的数据可以撤销
     * @return 返回执行成功的数据条数，如果没有则返回-1
     */
    @Override
    public int revokeDelete(Integer days) {
        Date now = new Date();
        return systemMenuMapper.revokeDelete(DateUtil.offsetDay(now,-days),now);
    }

    /**
     * 查询被执行逻辑删除的数据
     *
     * @param days 设定查询范围，查询在days天之内删除的数据
     * @return 返回已被执行逻辑删除的数据
     */
    @Override
    public List<SystemMenu> selectDeleted(Integer days) {
        Date now = new Date();
        return systemMenuMapper.selectDeleted(DateUtil.offsetDay(now,-days),now);
    }


}
