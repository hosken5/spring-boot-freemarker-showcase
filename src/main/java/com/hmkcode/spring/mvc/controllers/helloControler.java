package com.hmkcode.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hongpf on 15/7/29.
 */
@Controller
public class helloControler {

    @RequestMapping(value="/hel/lo", method = RequestMethod.GET)
    public @ResponseBody
    Object hello(){
        return  "hello";
    }
}