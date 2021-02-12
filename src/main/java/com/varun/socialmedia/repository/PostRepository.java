package com.varun.socialmedia.repository;

import com.varun.socialmedia.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

    public Post findByPostId(Long Id);
}
