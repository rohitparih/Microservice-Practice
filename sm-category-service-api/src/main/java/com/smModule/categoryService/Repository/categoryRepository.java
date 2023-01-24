package com.smModule.categoryService.Repository;

import com.smModule.categoryService.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : Rohit Parihar
 * Date : 11/22/2022
 * Time : 11:47 PM
 * Class : categoryRepository
 * Project : Bloggios-Backend
 */

public interface categoryRepository extends JpaRepository<Category, String> {
    Boolean existsByCategoryId(String categoryId);
}
