package com.ctrlcvs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BaoBao on 2017/9/23.
 */
@Controller
public class RouteController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String main(Model model) {
        return "/home";
    }

    @RequestMapping(value = "/article/index", method = RequestMethod.GET)
    public String article(Model model) {
        return "/article/article";
    }

    @RequestMapping(value = "/article/publish", method = RequestMethod.GET)
    public String articlePublish(Model model) {
        return "/article/article_publish";
    }

    @RequestMapping(value = "/category/index", method = RequestMethod.GET)
    public String category(Model model) {
        return "/category/category";
    }
}
