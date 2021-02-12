package com.varun.socialmedia.service;

import com.varun.socialmedia.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    public Comment createComment(Comment comment, Long userId, Long postId) throws Exception;
    public void deleteComment(Long commentId);

}
