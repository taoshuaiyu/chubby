package com.ctrlcvs.controller;

import com.ctrlcvs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting(Model model) {
        model.addAttribute("name", userService.getUserInfo().getUsername());
        logger.warn("name:::::" + userService.getUserInfo().getUsername());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "hello";
    }
}
