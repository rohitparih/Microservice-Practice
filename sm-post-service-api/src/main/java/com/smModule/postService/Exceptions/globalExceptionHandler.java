package com.smModule.postService.Exceptions;

import Exceptions.ApiException;
import com.smModule.postService.Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author : Rohit Parihar
 * Date : 11/28/2022
 * Time : 12:56 AM
 * Class : globalExceptionHandler
 * Project : Bloggios-Backend
 */

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> apiExceptionHandler(ApiException exception){
        String message = exception.getMessage();
        HttpStatus status = exception.getStatus();
        return new ResponseEntity<>(new ApiResponse(message, Boolean.FALSE), status);
    }
}
