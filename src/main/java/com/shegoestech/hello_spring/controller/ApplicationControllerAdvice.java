package com.shegoestech.hello_spring.controller;

import com.shegoestech.hello_spring.exception.BadRequestException;
import com.shegoestech.hello_spring.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<String> error = extractError(ex.getBindingResult());
        ResponseEntity<List<String>> response = new ResponseEntity<>(error, status);
        return this.handleExceptionInternal(ex, response, headers, status, request);
    }

    private List<String> extractError(BindingResult bindingResult) {
        List<String> error = new ArrayList<>();
        for (FieldError err : bindingResult.getFieldErrors()) {
            error.add(err.getField() + " : " + err.getDefaultMessage());
        }

        return error;
    }
}
