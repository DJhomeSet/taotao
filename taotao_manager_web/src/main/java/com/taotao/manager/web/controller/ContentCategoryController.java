package com.taotao.manager.web.controller;

import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.ContentCategory;
import com.taotao.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.portal.controller
 * @date 2018/2/25
 */
@Controller
@RequestMapping("content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ContentCategory> queryContentCategoryListByParentId(@RequestParam(value = "id",defaultValue = "0")Long parentId){
        List<ContentCategory> result = contentCategoryService.queryContentCategoryListByParentId(parentId);
        return result;
    }

    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public ContentCategory saveContentCategory(ContentCategory contentCategory){
        ContentCategory result = null;
        try {
            result = contentCategoryService.saveContentCategory(contentCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public String updateContentCategory(ContentCategory contentCategory){
        String msg = "0";
        try {
            contentCategoryService.updateByIdSelective(contentCategory);
        } catch (Exception e) {
            msg = "1";
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ResponseBody
    public String deleteContentCategory(ContentCategory contentCategory){
        String msg = "0";
        try {
            contentCategoryService.deleteContentCategory(contentCategory);
        } catch (Exception e) {
            msg = "1";
            e.printStackTrace();
        }
        return msg;
    }
}
