package com.mercury.final_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping // same thing as above
    @ResponseBody
    public String getHello() {
        // in Spring MVC, by default, if you return a string,
        // the string will be used as View Name
        return "Hello, Spring Boot!";
    }

}
