package com.varun.socialmedia.service;

import com.varun.socialmedia.domain.Following;
import com.varun.socialmedia.domain.User;

public interface UserService {
    public User createUser(User user);
    public User login(User user) throws Exception;
    public Following follow(Long userId, Long followId) throws Exception;
    public User updateProfilePicture(Long userId, String url) throws Exception;
    public Following getFollowedUsers(Long id) throws Exception;
}
