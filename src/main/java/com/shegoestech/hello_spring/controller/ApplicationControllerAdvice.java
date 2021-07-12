package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.exception.BadRequestException;
import com.shegoestech.hello_spring.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class, BadRequestException.class})
    public String exception(HttpServletResponse response, Throwable e) {
        HttpStatus httpStatus = null;
        if (e instanceof NotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else if (e instanceof BadRequestException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        response.setStatus(httpStatus.value());
        return e.getMessage();
    }
}
