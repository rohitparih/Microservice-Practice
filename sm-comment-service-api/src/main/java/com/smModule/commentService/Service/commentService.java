package com.smModule.commentService.Service;

import com.smModule.commentService.Payloads.commentRequest;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 1/11/2023
 * Time : 3:15 PM
 * Class : commentService
 * Project : Bloggios-Backend
 */

public interface commentService {
    commentRequest addComment(commentRequest commentRequest, String userId, String postId);
    commentRequest editComment(commentRequest commentRequest, String commentId, String userId);
    List<commentRequest> allCommentOfPost(String postId);
    commentRequest deleteComment(String postId, String userId, String commentId);
}
