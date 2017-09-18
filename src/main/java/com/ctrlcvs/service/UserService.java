package com.ctrlcvs.service;

import com.ctrlcvs.mapper.UserMapper;
import com.ctrlcvs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "'tsy'")
    public User getUserInfo() {
        return userMapper.findUserInfo();
    }

}
