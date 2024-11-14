package com.blogProject.controller;

import com.blogProject.entity.Post;
import com.blogProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins="*")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        try {
            Post createPost = postService.savedPost(post);
            return  ResponseEntity.status(HttpStatus.CREATED).body(createPost);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
