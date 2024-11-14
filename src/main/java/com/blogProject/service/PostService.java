package com.blogProject.service;

import com.blogProject.entity.Post;

import java.util.List;

public interface PostService {
    Post savedPost(Post post);
    List<Post> getAll();
}
