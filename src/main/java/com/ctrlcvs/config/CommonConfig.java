package com.ctrlcvs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author tsy
 * @Description
 * @date 11:31 2017/9/18
 */
@Configuration
public class CommonConfig extends WebMvcConfigurerAdapter {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置模板资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
