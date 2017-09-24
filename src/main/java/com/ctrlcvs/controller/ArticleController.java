package com.ctrlcvs.controller;

import com.ctrlcvs.common.TyResult;
import com.ctrlcvs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public TyResult list(@RequestParam Integer page,@RequestParam Integer limit) {
        TyResult result = TyResult.success(userService.getUserInfo(page,limit).getList());
        result.setCount(userService.getUserInfo(page,limit).getTotal());
        return result;
    }


}
