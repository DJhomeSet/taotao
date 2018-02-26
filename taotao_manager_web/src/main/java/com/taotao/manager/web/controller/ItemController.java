package com.taotao.manager.web.controller;

import com.github.pagehelper.PageHelper;
import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.Item;
import com.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.web.controller
 * @date 2018/2/24
 */
@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveItem(Item item,String desc){
        String msg = "0";
        try {
            itemService.saveItem(item,desc);
        } catch (Exception e) {
            msg = "1";
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TaoResult<Item> queryItemList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                         @RequestParam(value = "rows",defaultValue = "30")Integer rows){
        TaoResult<Item> easyUIResult= itemService.queryItemList(page,rows);
        return easyUIResult;
    }
}
