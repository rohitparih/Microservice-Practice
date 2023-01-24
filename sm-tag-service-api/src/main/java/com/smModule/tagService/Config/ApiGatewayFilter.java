package com.smModule.tagService.Config;

import Payloads.ApiResponse;
import SmCategoryServiceApiConstants.CategoryConstants;
import SmTagServiceApiConstants.TagConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Author : Rohit Parihar
 * Date : 12/28/2022
 * Time : 12:12 AM
 * Class : com.userModule.registrationService.Config.ApiGatewayFilter
 * Project : Bloggios-Backend
 */

@Configuration
public class ApiGatewayFilter extends GenericFilterBean {

    private static final String JSON_TYPE = "application/json";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String gatewayHeader = servletRequest.getHeader(TagConstants.GATEWAY_HEADER);
        if (!Objects.equals(gatewayHeader, TagConstants.GATEWAY_SECRET)){
            servletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(JSON_TYPE);
            OutputStream output = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(output, new ApiResponse(TagConstants.DIRECT_CALL_VALIDATION_RESPONSE, false));
            output.flush();
        }
        filterChain.doFilter(request, response);
    }
}
