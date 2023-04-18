package com.example.progettoBlogger.service;

import com.example.progettoBlogger.model.Post;

import java.util.List;

public interface BlogService {

    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
}
