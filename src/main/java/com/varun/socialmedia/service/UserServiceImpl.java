package com.varun.socialmedia.service;

import com.varun.socialmedia.domain.Following;
import com.varun.socialmedia.domain.User;
import com.varun.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

	private UserRepository repo;

	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public User login(User user) throws Exception{
		User foundUser = repo.findByUsername(user.getUsername());
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		}else {
			throw new Exception("Invalid username or password");
		}
	}

	@Override
	public Following follow(Long userId, Long followId) throws Exception{
		User user = repo.findByUserId(userId);
		User follow = repo.findByUserId(followId);
		if (user == null || follow == null) {
			throw new Exception("user does not exist");
		}
		user.getFollowing().add(follow);
		repo.save(user);
		return new Following(user);
	}

	@Override
	public User updateProfilePicture(Long userId, String url) throws Exception{
		User user = repo.findByUserId(userId);
		if(user == null) {
			throw new Exception("user does not exist");
		}
		user.setProfilePictureUrl(url);
		return repo.save(user);
	}

	@Override
	public Following getFollowedUsers(Long id) throws Exception {
		return follow(null, null);
	}
}
