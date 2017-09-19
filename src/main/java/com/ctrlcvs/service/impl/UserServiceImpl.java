package com.ctrlcvs.service.impl;

import com.ctrlcvs.mapper.UserMapper;
import com.ctrlcvs.model.User;
import com.ctrlcvs.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tsy
 * @Description
 * @date 10:23 2017/9/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo() {
        PageHelper.startPage(0, 2);
        Example example = new Example(User.class);
        List<User> userList = userMapper.selectByExample(example);
        return userList.get(0);
    }
}
