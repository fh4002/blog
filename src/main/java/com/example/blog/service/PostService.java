package com.example.blog.service;

import com.example.blog.dto.request.CreatePostRequest;
import com.example.blog.dto.request.UpdatePostRequest;
import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(CreatePostRequest createPostRequest){
        Post newPost = Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                //.author(createPostRequest.getAuthor())
                .build();

        postRepository.save(newPost);
    }

    public void deletePost(Long PostId){
        postRepository.deleteById(PostId);
    }

    public void updatePost(Long postId, UpdatePostRequest updatePostRequest){
        Post post = postRepository.findById(postId)
                .orElseThrow( () -> new IllegalArgumentException
                        ("글을 찾을 수 없음"));

        post.update(updatePostRequest.getContent());
    }
}
