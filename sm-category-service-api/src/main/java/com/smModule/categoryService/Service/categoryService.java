package com.smModule.categoryService.Service;

import com.smModule.categoryService.Payload.categoryRequest;
import com.smModule.categoryService.Payload.categoryResponse;

/**
 * Author : Rohit Parihar
 * Date : 11/22/2022
 * Time : 11:19 PM
 * Class : categoryService
 * Project : Bloggios-Backend
 */

public interface categoryService {
    categoryResponse addCategory(categoryRequest categoryRequest, String userId);
    categoryResponse getCategoryById(String id);
    categoryResponse updateCategory(String categoryId, categoryRequest categoryRequest, String userId);
    categoryResponse deleteCategory(String id);
    Boolean checkByCategoryId(String categoryId);
}
