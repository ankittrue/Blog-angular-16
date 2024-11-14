package com.blogProject.service;

import com.blogProject.entity.Post;
import com.blogProject.entity.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    public  Post savedPost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());
        return postRepository.save(post);
    }
    public List<Post> getAll(){
        return postRepository.findAll();
    }
}
