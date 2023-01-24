package com.smModule.postService.Config;

import Payloads.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Author : Rohit Parihar
 * Date : 12/30/2022
 * Time : 12:34 AM
 * Class : MyAccessDeniedHandler
 * Project : Bloggios-Backend
 */

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private static final String JSON_TYPE = "application/json";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(JSON_TYPE);
        OutputStream output = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(output, new ApiResponse("Not Authorized to access this resource", false));
        output.flush();
    }
}
