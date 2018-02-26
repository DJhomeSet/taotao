package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.portal.controller
 * @date 2018/2/25
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
}
