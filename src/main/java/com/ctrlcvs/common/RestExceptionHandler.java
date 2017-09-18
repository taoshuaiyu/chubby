package com.ctrlcvs.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tsy
 * @Description
 * @date 15:34 2017/9/15
 */
@ControllerAdvice(annotations = Controller.class)
@ResponseBody
public class RestExceptionHandler {

    /**
     * 默认统一异常处理方法
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return new ApiResult().error(e.getMessage());
    }
}
