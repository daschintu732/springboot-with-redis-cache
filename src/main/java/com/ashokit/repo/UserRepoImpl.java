package com.ashokit.repo;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.binding.User;

@Repository
public class UserRepoImpl implements UserRepository {

	private HashOperations<String, String, User> hashOperations;

	public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER");
	}

	@Override
	public User findById(String id) {
		User user = (User) hashOperations.get("USER", id);
		return user;
	}

	@Override
	public void update(User user) {
		save(user);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
	}
}
