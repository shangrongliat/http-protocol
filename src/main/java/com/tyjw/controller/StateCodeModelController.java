package com.tyjw.controller;

import com.tyjw.bean.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/request/state/model/")
public class StateCodeModelController {

    @RequestMapping(value = "204",method = RequestMethod.GET)
    public Teacher _204(){
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setValue("去逛街");
        return teacher;
    }

    @RequestMapping(value = "204/1",method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Teacher _204_01(){
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setValue("去逛街");
        return teacher;
    }

    @RequestMapping(value = "204/2",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Teacher _204_02(){
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setValue("去逛街");
        return teacher;
    }

    @RequestMapping(value = "205",method = RequestMethod.GET)
//    @ResponseStatus(value= HttpStatus.RESET_CONTENT)
    public Teacher _205(){
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setValue("去逛街");
        return teacher;
    }


    @RequestMapping(value = "301 ",method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.MOVED_PERMANENTLY)
    public ModelAndView _301(HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/index4");
        return modelAndView;
    }

    @RequestMapping(value = "301/1",method = RequestMethod.GET)
//    @ResponseStatus(value= HttpStatus.MOVED_PERMANENTLY)
    public ModelAndView _301_1(HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/index4");
        return modelAndView;
    }
    @RequestMapping(value = "301/2",method = RequestMethod.GET)
//    @ResponseStatus(value= HttpStatus.MOVED_PERMANENTLY)
    public String _301_2(){
        return "redirect:/index4";
    }
}
