package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.BaseService;
import com.taotao.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service.impl
 * @date 2018/2/16
 */
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<ItemCat> implements ItemCatService{
    @Override
    public List<ItemCat> queryItemCatByParentId(Long parentId) {
        ItemCat param = new ItemCat();
        param.setParentId(parentId);
        List<ItemCat> itemCats = super.queryListByWhere(param);
        return itemCats;
    }
   /*@Autowired
    private ItemCatMapper itemCatMapper;
    @Override
    public List<ItemCat> queryItemCatByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        return itemCatMapper.select(null);
    }*/
}
