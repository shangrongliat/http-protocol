package com.tyjw.controller;

import com.tyjw.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 国际化加页面访问
 */
@Controller
public class PageModelController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(Model model) {
        /*
         Accept-Language: en-US,en;q=0.5 英文
         Accept-Language: zh-CN,zh;q=0.9,en;q=0.8 中文
         */
        model.addAttribute("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String hello2() {
        return "index2";
    }

    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public String hello3() {
        return "index2";
    }

    @RequestMapping(value = "/index4", method = RequestMethod.GET)
    public String hello4() {
        return "index3";
    }
}
