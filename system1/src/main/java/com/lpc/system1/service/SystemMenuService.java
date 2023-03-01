/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.service;


import com.lpc.system1.model.SystemMenu;

import java.util.List;

public interface SystemMenuService {

    /**
     * 添加菜单数据
     * @param menu
     * @return
     */
    boolean add(SystemMenu menu);

    /**
     * 修改菜单
     */
    boolean update(SystemMenu menu);

    /**
     * 根据菜单Id查询菜单
     * @param menuId
     * @return
     */
    SystemMenu selectById(Integer menuId);

    /**
     * 撤销逻辑删除
     * @param days 设定在days天之内删除的数据可以撤销
     * @return 返回执行成功的数据条数，如果没有则返回-1
     */
    int revokeDelete(Integer days);

    /**
     * 查询被执行逻辑删除的数据
     * @param days 设定查询范围，查询在days天之内删除的数据
     * @return 返回已被执行逻辑删除的数据
     */
    List<SystemMenu> selectDeleted(Integer days);

}
