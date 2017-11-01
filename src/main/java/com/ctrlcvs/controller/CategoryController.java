package com.ctrlcvs.controller;

import com.ctrlcvs.common.TyResult;
import com.ctrlcvs.model.User;
import com.ctrlcvs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public TyResult list(@RequestParam Integer page, @RequestParam Integer limit) {
        PageInfo<User> pageInfo = userService.getUserInfo(page, limit);
        return TyResult.success(pageInfo.getList(), pageInfo.getTotal());
    }
}
