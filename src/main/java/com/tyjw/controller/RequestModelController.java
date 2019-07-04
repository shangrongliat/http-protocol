package com.tyjw.controller;

import com.tyjw.bean.Student;
import com.tyjw.bean.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/request/model/", produces = "application/json; charset=utf-8")
public class RequestModelController {

    /**
     * GET 获取资源
     * 此方法用来请求访问已被URI识别的资源。指定的资源经服务端解析后返回响应内容
     * CGI（Common Gateway Interface） 通用网关接口
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getModel(HttpServletResponse response, Teacher teacher) {
        Cookie cookie = new Cookie(teacher.getName(), teacher.getValue());
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return teacher;
    }

    /**
     * POST 传输实体主体
     * POST方法是用来传输实体的主体。
     * 次方法的主要目的并不是获取响应数据的。
     */
    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public Student postModel(HttpServletRequest request, Student student) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
           for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[0].getName());
                System.out.println(cookies[0].getValue());
            }
        }
        return student;
    }

    /**
     * PUT传输文件
     * 此方法是用来输出文件的，就像FTP协议的文件上传一样，要求在请求报文的主体中包含文件内容
     * 然后保存到请求URI指定的位置
     *
     */
    @RequestMapping(value = "put",method = RequestMethod.PUT)
    public String put(){
        return "";
    }

}
