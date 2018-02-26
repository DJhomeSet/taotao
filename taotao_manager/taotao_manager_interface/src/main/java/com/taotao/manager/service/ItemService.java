package com.taotao.manager.service;

import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.Item;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service
 * @date 2018/2/24
 */
public interface ItemService extends BaseService<Item>{
    public void saveItem(Item item,String desc);

    TaoResult<Item> queryItemList(Integer page, Integer rows);
}
