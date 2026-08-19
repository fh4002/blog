package com.example.blog.controller;

import com.example.blog.dto.request.CreatePostRequest;
import com.example.blog.dto.request.UpdateMemberRequest;
import com.example.blog.dto.request.UpdatePostRequest;
import com.example.blog.dto.response.UpdateMemberResponse;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody CreatePostRequest request){
        postService.createPost(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteMapping(@RequestBody Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<UpdateMemberResponse> updatePost(@RequestBody Long postId){
        UpdatePostRequest request = PostService.updatePost(postId);
        return ResponseEntity.ok().build();
    }
}
