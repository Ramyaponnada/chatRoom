package com.assignment.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String succss() {

        return "index.html";
    }
}

