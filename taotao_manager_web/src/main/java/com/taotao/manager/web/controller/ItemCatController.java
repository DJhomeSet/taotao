package com.taotao.manager.web.controller;

import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.web.controller
 * @date 2018/2/16
 */
@Controller
@RequestMapping("item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("query/{page}")
    @ResponseBody
    public List<ItemCat> queryItemCatByPage(@PathVariable("page")Integer page, @RequestParam("rows")Integer rows){
//        List<ItemCat> list = itemCatService.queryItemCatByPage(page,rows);
        List<ItemCat> list = this.itemCatService.queryByPage(page, rows);
        return list;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ItemCat> queryItemCatByParentId(@RequestParam(value="id",defaultValue = "0")Long parentId){
        return itemCatService.queryItemCatByParentId(parentId);
    }
}
