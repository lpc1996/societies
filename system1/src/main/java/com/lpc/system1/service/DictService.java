/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.service;


import com.lpc.system1.model.Dict;
import com.lpc.system1.model.DictType;
import com.lpc.system1.model.response.ResponseMessage;

/**
 * @CreateTime 2023/2/16-23:36
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 * 字典数据业务服务
 */
public interface DictService {

    /**
     * 获取字典数据列表
     * @return
     */
    ResponseMessage typeList();

    /**
     * 根据字典类型名称查询字典类型
     * 字典类型名称在全表中唯一
     * @param dictTypeName
     * @return
     */
    ResponseMessage findTypeByName(String dictTypeName);

    /**
     * 添加数据字典类型
     * @param type
     * @return
     */
    ResponseMessage addType(DictType type);

    /**
     * 更新数据字典类型
     * @param type
     * @return
     */
    ResponseMessage updateType(DictType type);

    /**
     * 删除数据字典类型
     * @param type
     * @return
     */
    ResponseMessage deleteType(DictType type);

    /**
     * 获取数据字典数据
     * @return
     */
    ResponseMessage valueList();

    /**
     * 根据字典类型编码获取字典列表数据
     * @param typeId 数据字典类型的id
     * @return
     */
    ResponseMessage valueList(Integer typeId);

    /**
     * 新增数据字典数据
     * @param dict
     * @return
     */
    ResponseMessage addValue(Dict dict);

    /**
     * 更新数据字典
     * @param dict
     * @return
     */
    ResponseMessage updateValue(Dict dict);

    /**
     * 删除字典数据
     * @param dict
     * @return
     */
    ResponseMessage deleteValue(Dict dict);

    ResponseMessage typeList(Integer page, Integer count);
}
