/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lpc.system1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lpc.system1.mapper.DictMapper;
import com.lpc.system1.mapper.DictTypeMapper;
import com.lpc.system1.model.Dict;
import com.lpc.system1.model.DictType;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import com.lpc.system1.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @CreateTime 2023/2/16-23:41
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project SocietiesSystem
 * 字典数据服务实现
 */

@Slf4j
@Service
@Transactional
public class DictServiceImpl implements DictService {

    @Resource
    private DictTypeMapper dictTypeMapper;

    @Resource
    private DictMapper dictMapper;

    /**
     * 获取字典数据列表
     *
     * @return
     */
    @Override
    public ResponseMessage typeList() {
        QueryWrapper<DictType> queryWrapper = new QueryWrapper<>();
        ResponseMessage responseMessage = ResponseMessage.newInstancec(
                ResponseMessageEnum.REQUEST_SUCCESS,
                dictTypeMapper.selectList(queryWrapper));
        return responseMessage;
    }

    /**
     * 根据字典类型名称查询字典类型
     * 字典类型在全表中唯一
     *
     * @param dictTypeName
     * @return
     */
    @Override
    public ResponseMessage findTypeByName(String dictTypeName) {
        QueryWrapper<DictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.camelToUnderline("dictType"),dictTypeName);
        DictType dictType = dictTypeMapper.selectOne(queryWrapper);
        return dictType == null ? ResponseMessage.newInstancec(
                ResponseMessageEnum.DICT_TYPE_SELECT_FAIL) :
                ResponseMessage.newInstancec(ResponseMessageEnum.REQUEST_SUCCESS,
                        dictType);
    }

    /**
     * 添加数据字典类型
     * 字典类型字典中dictType属性必须为唯一值
     * @param type
     * @return
     */
    @Override
    public ResponseMessage addType(DictType type) {
        QueryWrapper<DictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.camelToUnderline("dictType"),type.getDictType());

        if(dictTypeMapper.selectCount(queryWrapper) == 0){
            return dictTypeMapper.insert(type) == 1 ?
                    ResponseMessage.newInstancec(
                    ResponseMessageEnum.REQUEST_SUCCESS):
                    ResponseMessage.newInstancec(
                            ResponseMessageEnum.DICT_TYPE_INSERT_FAIL);
        }
        log.info("添加字典类型失败，dictType字段必须唯一");
        return ResponseMessage.newInstancec(
                ResponseMessageEnum.DICT_TYPE_INSERT_FAIL);
    }

    /**
     * 更新数据字典类型
     *
     * @param type
     * @return
     */
    @Override
    public ResponseMessage updateType(DictType type) {
        return dictTypeMapper.updateById(type) == 1 ?
                ResponseMessage.newInstancec(
                        ResponseMessageEnum.REQUEST_SUCCESS) :
                ResponseMessage.newInstancec(
                        ResponseMessageEnum.DICT_TYPE_UPDATE_FAIL);
    }

    /**
     * 删除数据字典类型
     *
     * @param type
     * @return
     */
    @Override
    public ResponseMessage deleteType(DictType type) {
        return dictTypeMapper.deleteById(type) == 1 ?
                ResponseMessage.newInstancec(ResponseMessageEnum.REQUEST_SUCCESS) :
                ResponseMessage.newInstancec(ResponseMessageEnum.DICT_TYPE_DELETE_FAIL);
    }

    /**
     * 获取数据字典数据
     *
     * @return
     */
    @Override
    public ResponseMessage valueList() {
        return ResponseMessage.newInstancec(
                ResponseMessageEnum.REQUEST_SUCCESS,
                dictMapper.selectList(null));
    }

    /**
     * 根据字典类型编码获取字典列表数据
     *
     * @param typeId 数据字典类型的id
     * @return
     */
    @Override
    public ResponseMessage valueList(Integer typeId) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.camelToUnderline("dictCode"),typeId);
        return ResponseMessage.newInstancec(ResponseMessageEnum.REQUEST_SUCCESS,
                dictMapper.selectList(null));
    }

    /**
     * 新增数据字典数据
     *
     * @param dict
     * @return
     */
    @Override
    public ResponseMessage addValue(Dict dict) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.camelToUnderline("dictType"),dict.getDictType());
        queryWrapper.eq(StringUtils.camelToUnderline("dictValue"),dict.getDictValue());
        if(dictMapper.selectCount(queryWrapper) == 0){
            return dictMapper.insert(dict) == 1 ? ResponseMessage.newInstancec(
                    ResponseMessageEnum.REQUEST_SUCCESS) :
                    ResponseMessage.newInstancec(ResponseMessageEnum.DICT_VALUE_INSERT_FAIL);
        }
        log.info("同一个字典类型下的字典键值不允许重复");
        return ResponseMessage.newInstancec(ResponseMessageEnum.DICT_VALUE_INSERT_FAIL);
    }

    /**
     * 更新数据字典
     *
     * @param dict
     * @return
     */
    @Override
    public ResponseMessage updateValue(Dict dict) {
        return dictMapper.updateById(dict) == 1 ?
                ResponseMessage.newInstancec(
                ResponseMessageEnum.REQUEST_SUCCESS) :
                ResponseMessage.newInstancec(
                        ResponseMessageEnum.DICT_VALUE_UPDATE_FAIL);
    }

    /**
     * 删除字典数据
     *
     * @param dict
     * @return
     */
    @Override
    public ResponseMessage deleteValue(Dict dict) {
        return dictMapper.deleteById(dict) == 1?
                ResponseMessage.newInstancec(
                        ResponseMessageEnum.REQUEST_SUCCESS) :
                ResponseMessage.newInstancec(
                        ResponseMessageEnum.DICT_VALUE_DELETE_FAIL);
    }

    @Override
    public ResponseMessage typeList(Integer pageNum, Integer count) {
        ResponseMessage responseMessage = null;
        QueryWrapper<DictType> queryWrapper = new QueryWrapper<>();
        Page<DictType> page = PageHelper.startPage(pageNum, count);
        dictTypeMapper.selectList(null);
        System.out.println(page);
        if(page.getPageSize() > 0){
            responseMessage = ResponseMessage.newInstances(ResponseMessageEnum.REQUEST_SUCCESS,page.getPages(),page.getPageSize(),page.getResult());
        }else{
            responseMessage = ResponseMessage.newInstancec(ResponseMessageEnum.DICT_TYPE_SELECT_FAIL);
        }
        return responseMessage;
    }
}
