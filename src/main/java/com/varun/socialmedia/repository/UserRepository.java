package com.varun.socialmedia.repository;

import com.varun.socialmedia.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    public User findByUsername(String username);

    public User findByUserId(Long userId);
}
