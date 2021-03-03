package com.qsn.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author qiusn
 * @version 1.0 2019/11/13 15:56
 */
@Slf4j
@RestControllerAdvice
public class ExceptionConf {

    /**
     * 捕获全局异常, 将异常信息输出
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public String handler(Exception e) {
        // 输出异常信息
        log.error(e.getMessage());
        return "{\"status\":\"error\",\"message\":\"系统异常\"}";
    }


}
