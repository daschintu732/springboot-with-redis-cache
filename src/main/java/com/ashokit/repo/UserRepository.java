package com.ashokit.repo;

import java.util.Map;

import com.ashokit.binding.User;

public interface UserRepository {

	void save(User user);

	Map<String, User> findAll();

	User findById(String id);

	void update(User user);

	void delete(String id);
}
