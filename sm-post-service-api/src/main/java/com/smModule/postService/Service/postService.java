package com.smModule.postService.Service;

import com.smModule.postService.Entity.Post;
import com.smModule.postService.Payloads.GetPostResponse;
import com.smModule.postService.Payloads.pagedResponse;
import com.smModule.postService.Payloads.postRequest;
import com.smModule.postService.Payloads.postResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:10 PM
 * Class : postService
 * Project : Bloggios-Backend
 */

public interface postService {
    postResponse createPost(postRequest postRequest, String userId) throws ExecutionException, InterruptedException;
    postResponse updatePost(postRequest postRequest, String postId, String userId);
    GetPostResponse getPost(String postId);
    List<pagedResponse> getAllPosts(Long pageNumber, Long pageSize);
    List<pagedResponse> getAllPostsByCategory(String categoryId, Long pageNumber, Long pageSize);
    List<pagedResponse> getAllPostsByTags(String tagId, Long pageNumber, Long pageSize);
    postResponse deletePost(String postId);
    postResponse deletePostPermanently(String postId);
}
