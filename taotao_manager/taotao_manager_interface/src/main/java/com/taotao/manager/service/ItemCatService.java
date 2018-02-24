package com.taotao.manager.service;

import com.taotao.manager.pojo.ItemCat;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service
 * @date 2018/2/16
 */
public interface ItemCatService {
    /**
     * query itemCat by page
     * @param page
     * @param rows
     * @return
     */
    List<ItemCat> queryItemCatByPage(Integer page,Integer rows);
}
