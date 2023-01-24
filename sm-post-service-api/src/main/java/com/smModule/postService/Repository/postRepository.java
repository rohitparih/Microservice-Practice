package com.smModule.postService.Repository;

import com.smModule.postService.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:01 PM
 * Class : postRepository
 * Project : Bloggios-Backend
 */

public interface postRepository extends JpaRepository<Post, String> {
    Post findByCaptionIgnoreCase(String postId);
}
