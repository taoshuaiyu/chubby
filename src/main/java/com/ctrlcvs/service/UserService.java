package com.ctrlcvs.service;

import com.ctrlcvs.model.User;
import com.github.pagehelper.PageInfo;

/**
 * @author tsy
 * @Description
 * @date 10:21 2017/9/19
 */
public interface UserService {

    public PageInfo<User> getUserInfo(Integer page,Integer limit);
}
