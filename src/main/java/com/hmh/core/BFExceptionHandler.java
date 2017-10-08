package com.hmh.core;

import javax.servlet.http.HttpServletRequest;

import com.hmh.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常处理
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年12月01日
 * @see
 * @since webbf V1.0.0
 */
@ControllerAdvice
public class BFExceptionHandler extends BaseController
{

    /**
     * 处理controller抛出的异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Exception> handleException(HttpServletRequest request, Exception e)
    {
        logger.error("Request FAILD, URL = {} method = {}", request.getRequestURI(), request.getMethod());
        logger.error(e.toString(), e);
        return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理controller抛出的异常
     *
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<Exception> handleNumberFormatException(HttpServletRequest request, NumberFormatException e)
    {
        logger.error("Request FAILD, URL = {} method = {}", request.getRequestURI(), request.getMethod());
        logger.error(e.toString(), e);
        return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /* other exception */
}
