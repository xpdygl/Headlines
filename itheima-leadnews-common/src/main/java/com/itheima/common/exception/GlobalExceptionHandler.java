package com.itheima.common.exception;

import com.itheima.common.pojo.Result;
import com.itheima.common.pojo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice//标识这个是全局异常处理类  rest表示返回的都是JSON
public class GlobalExceptionHandler {


    //写一个方法  方法 用于当controller发送异常的时候被调用 要捕获异常 代替 controller 去返回给前端
    //系统异常
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
        //e.printStackTrace();
        log.error("系统异常",e);
        return Result.error();
    }

    //LeadNewsException业务上的异常 才进行处理
    @ExceptionHandler(LeadNewsException.class)
    public Result handlerLeadNewsException(LeadNewsException e){
        //e.printStackTrace();
        log.error("系统异常",e);
        return Result.errorMessage(e.getMessage());
    }
}
