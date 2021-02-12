package com.varun.socialmedia.service;

import com.varun.socialmedia.domain.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    public Iterable<Post> getAllPosts();
    public Post getPost(Long id);
    public Post updatePost(Post post, Long id) throws Exception;
    public Post createPost(Post post, Long userId) throws Exception;
}
