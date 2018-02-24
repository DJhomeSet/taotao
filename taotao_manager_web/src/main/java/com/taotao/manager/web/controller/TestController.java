package com.taotao.manager.web.controller;

import com.taotao.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.web.controller
 * @date 2018/2/6
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("date")
    @ResponseBody
    public String queryDate(){
        return this.testService.queryDate();
    }
}
