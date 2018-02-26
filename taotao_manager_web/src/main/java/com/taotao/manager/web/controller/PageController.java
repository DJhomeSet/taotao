package com.taotao.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.web.controller
 * @date 2018/2/24
 */
@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("{pageName}")
    public String toPage(@PathVariable(value = "pageName")String pageName){
        return pageName;
    }
}
