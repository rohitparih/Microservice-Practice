package com.smModule.postService.Controller;

import SmPostServiceApiConstants.PostConstants;
import com.smModule.postService.Config.CustomPrincipal;
import com.smModule.postService.Payloads.GetPostResponse;
import com.smModule.postService.Payloads.postRequest;
import com.smModule.postService.Payloads.postResponse;
import com.smModule.postService.Service.postService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:13 PM
 * Class : postController
 * Project : Bloggios-Backend
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/sm-post")
public class postController {

    private final postService postService;

    @PostMapping("/auth/createPost")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = "post", fallbackMethod = "createPostFallback")
    @TimeLimiter(name = "post")
    @Retry(name = "post")
    public CompletableFuture<postResponse> createPost(@RequestBody postRequest postRequest, CustomPrincipal customPrincipal) throws ExecutionException, InterruptedException {
        postResponse response = this.postService.createPost(postRequest, customPrincipal.getUserId());
        return CompletableFuture.supplyAsync(()-> response);
    }

    public CompletableFuture<String> createPostFallback(RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()-> PostConstants.CREATE_POST_FALLBACK);
    }

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public GetPostResponse getPost(@PathVariable String postId){
        GetPostResponse post = this.postService.getPost(postId);
        return post;
    }
}
