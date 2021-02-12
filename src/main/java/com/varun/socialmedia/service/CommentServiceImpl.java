package com.varun.socialmedia.service;

import com.varun.socialmedia.domain.Comment;
import com.varun.socialmedia.domain.Post;
import com.varun.socialmedia.domain.User;
import com.varun.socialmedia.repository.CommentRepository;
import com.varun.socialmedia.repository.PostRepository;
import com.varun.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository repo;
    private PostRepository postRepo;
    private UserRepository userRepo;

    public CommentServiceImpl(CommentRepository repo, PostRepository postRepo, UserRepository userRepo) {
        this.repo = repo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Comment createComment(Comment comment, Long userId, Long postId) throws Exception {
        User user = userRepo.findByUserId(userId);
        Post post = postRepo.findByPostId(postId);
        if (user == null || post == null) {
            throw new Exception("User or Post does not exist.");
        }
        comment.setDate(new Date());
        comment.setUser(user);
        comment.setPost(post);
        return repo.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        repo.deleteById(commentId);
    }
}
