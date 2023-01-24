package com.smModule.categoryService.Controller;

import com.smModule.categoryService.Config.CustomPrincipal;
import com.smModule.categoryService.Payload.categoryRequest;
import com.smModule.categoryService.Payload.categoryResponse;
import com.smModule.categoryService.Service.categoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : Rohit Parihar
 * Date : 11/23/2022
 * Time : 12:30 AM
 * Class : categoryController
 * Project : Bloggios-Backend
 */

@RestController
@RequestMapping("/sm-category")
@RequiredArgsConstructor
@Slf4j
public class categoryController {

    private final categoryService categoryService;

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('role_admin')")
    public categoryResponse addCategory(@RequestBody categoryRequest categoryRequest, CustomPrincipal customPrincipal){
        categoryResponse categoryResponse = categoryService.addCategory(categoryRequest, customPrincipal.getUserId());
        return categoryResponse;
    }

    @GetMapping("auth/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public categoryResponse getCategoryById(@PathVariable String categoryId, HttpServletRequest request){
        log.warn("Category by Id request raised");
        categoryResponse categoryById = categoryService.getCategoryById(categoryId);
        String testing = request.getHeader("testing");
        log.error(testing);
        return categoryById;
    }

    @PutMapping("auth/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin')")
    public categoryResponse updateCategory(@PathVariable String categoryId, @RequestBody categoryRequest categoryRequest, CustomPrincipal customPrincipal){
        log.warn("Update Category request raised");
        categoryResponse categoryResponse = categoryService.updateCategory(categoryId, categoryRequest, customPrincipal.getUserId());
        return categoryResponse;
    }

    @DeleteMapping("auth/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin')")
    public categoryResponse deleteCategory(@PathVariable String categoryId){
        log.warn("Delete Category request raised");
        categoryResponse categoryResponse = categoryService.deleteCategory(categoryId);
        return categoryResponse;
    }

    @GetMapping("/check-id/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean checkByCategoryId(@PathVariable String categoryId){
        return this.categoryService.checkByCategoryId(categoryId);
    }
}
