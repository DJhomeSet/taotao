package com.taotao.manager.web.controller;

import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.Content;
import com.taotao.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.portal.controller
 * @date 2018/2/25
 */
@Controller
@RequestMapping("content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //categoryId=0&page=1&rows=20
    public TaoResult<Content> queryContentListByPage(Long categoryId,Integer page,Integer rows){
       TaoResult<Content> result = contentService.queryContentListByPage(categoryId,page,rows);
       return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveContent(Content content){
        String msg = "0";
        try {
            contentService.save(content);
        } catch (Exception e) {
            msg = "1";
            e.printStackTrace();
        }
        return msg;
    }
}
