package com.ctrlcvs;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BlogApplication.class).bannerMode(Banner.Mode.CONSOLE).run(args);
    }
}
