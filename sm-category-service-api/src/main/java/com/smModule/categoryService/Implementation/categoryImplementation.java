package com.smModule.categoryService.Implementation;

import Exceptions.ApiException;
import SmCategoryServiceApiConstants.CategoryConstants;
import com.smModule.categoryService.Payload.categoryRequest;
import com.smModule.categoryService.Payload.categoryResponse;
import com.smModule.categoryService.Entity.Category;
import com.smModule.categoryService.Repository.categoryRepository;
import com.smModule.categoryService.Service.categoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Author : Rohit Parihar
 * Date : 11/22/2022
 * Time : 11:48 PM
 * Class : categoryImplementation
 * Project : Bloggios-Backend
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class categoryImplementation implements categoryService {

    private final categoryRepository categoryRepository;

    /**
     *
     * @createdBy Rohit Parihar
     * @param categoryRequest, userId
     * @return categoryResponse
     */
    @Override
    public categoryResponse addCategory(categoryRequest categoryRequest, String userId) {
        Category category = Category
                .builder()
                .title(categoryRequest.getTitle())
                .description(categoryRequest.getDescription())
                .createdBy(userId)
                .dateCreated(new Date())
                .build();
        Category savedCategory = categoryRepository.save(category);
        return categoryResponse
                .builder()
                .categoryId(savedCategory.getCategoryId())
                .createdBy(savedCategory.getCreatedBy())
                .isAdded(true)
                .build();
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param id
     * @return categoryResponse
     */
    @Override
    public categoryResponse getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, CategoryConstants.CATEGORY_NOT_FOUND_MESSAGE));
        return categoryResponse
                .builder()
                .title(category.getTitle())
                .description(category.getDescription())
                .createdBy(category.getCreatedBy())
                .categoryId(category.getCategoryId())
                .build();
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param categoryId, categoryRequest, userId
     * @return categoryResponse
     */
    @Override
    public categoryResponse updateCategory(String categoryId, categoryRequest categoryRequest, String userId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, CategoryConstants.CATEGORY_NOT_FOUND_MESSAGE));
        String title = category.getTitle();
        String description = category.getDescription();
        category.setTitle(categoryRequest.getTitle()==null ? category.getTitle() : categoryRequest.getTitle());
        category.setDescription(categoryRequest.getDescription()==null ? category.getDescription() : categoryRequest.getDescription());
        category.setUpdatedBy(userId);
        category.setLastModified(new Date());
        Category updatedcategory = categoryRepository.save(category);
        return categoryResponse
                .builder()
                .categoryId(updatedcategory.getCategoryId())
                .createdBy(updatedcategory.getCreatedBy())
                .updatedBy(updatedcategory.getUpdatedBy())
                .title(updatedcategory.getTitle())
                .description(updatedcategory.getDescription())
                .isUpdated(true)
                .build();
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param id, userId
     * @return categoryResponse
     */
    @Override
    public categoryResponse deleteCategory(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, CategoryConstants.CATEGORY_NOT_FOUND_MESSAGE));
        categoryRepository.delete(category);
        return categoryResponse
                .builder()
                .categoryId(category.getCategoryId())
                .isDeleted(true)
                .build();
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param categoryId
     * @return Boolean
     */
    @Override
    public Boolean checkByCategoryId(String categoryId) {
        return categoryRepository.existsByCategoryId(categoryId);
    }
}
