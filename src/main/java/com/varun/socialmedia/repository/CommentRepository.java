package com.varun.socialmedia.repository;


import com.varun.socialmedia.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    void deleteById(Long commentId);
}
