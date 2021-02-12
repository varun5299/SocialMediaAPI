package com.varun.socialmedia.service;


import com.varun.socialmedia.domain.Post;
import com.varun.socialmedia.domain.User;
import com.varun.socialmedia.repository.PostRepository;
import com.varun.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService{


    private PostRepository repo;
    private UserRepository userRepo;

    public PostServiceImpl(PostRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<Post> getAllPosts() {
        return repo.findAll();
    }

    @Override
    public Post getPost(Long id) {
        return repo.findByPostId(id);
    }

    @Override
    public Post updatePost(Post post, Long id) throws Exception {
        Post foundPost = repo.findByPostId(id);
        if (foundPost == null) {
            throw new Exception("Post not found.");
        }
        foundPost.setContent(post.getContent());
        return repo.save(foundPost);
    }

    @Override
    public Post createPost(Post post, Long userId) throws Exception {
        User user = userRepo.findByUserId(userId);
        if (user == null) {
            throw new Exception("User not found.");
        }
        post.setDate(new Date());
        post.setUser(user);
        return repo.save(post);
    }

}
