package com.ctrlcvs.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author tsy
 * @Description
 * @date 11:06 2017/9/19
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
