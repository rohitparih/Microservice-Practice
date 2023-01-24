package com.smModule.categoryService.Exception;

import Exceptions.ApiException;
import Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author : Rohit Parihar
 * Date : 12/31/2022
 * Time : 12:08 AM
 * Class : globalExceptionHandler
 * Project : Bloggios-Backend
 */

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> apiException(ApiException apiException){
        String message = apiException.getMessage();
        HttpStatus status = apiException.getStatus();
        return new ResponseEntity<>(new ApiResponse(message, Boolean.FALSE), status);
    }
}
