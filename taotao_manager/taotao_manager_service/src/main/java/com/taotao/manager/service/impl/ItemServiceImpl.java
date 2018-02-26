package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.service.BaseService;
import com.taotao.manager.service.ItemDescService;
import com.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service.impl
 * @date 2018/2/24
 */
@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    @Autowired
    private ItemDescService itemDescService;

    @Override
    public void saveItem(Item item, String desc) {
        item.setStatus(1);
        super.save(item);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(item.getId());
        this.itemDescService.save(itemDesc);
    }

    @Override
    public TaoResult<Item> queryItemList(Integer page, Integer rows) {
        TaoResult<Item> result = new TaoResult<Item>();
        PageHelper.startPage(page,rows,true);
        List<Item> items = super.queryListByWhere(null);
        result.setRows(items);
        PageInfo pageInfo = new PageInfo(items);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
