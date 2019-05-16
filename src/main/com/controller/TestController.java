package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wang
 */
@Controller
@Slf4j
public class TestController {
    @Autowired

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
       log.debug("-------------------------------------------helloController invoke");
        return "/Hello";
    }
}

