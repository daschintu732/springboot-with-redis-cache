package com.ashokit.rest;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.User;
import com.ashokit.repo.UserRepository;

@RestController
public class UserRestController {

	private UserRepository repository;

	public UserRestController(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public User addUser(@RequestBody User user) {
		repository.save(user);
		return repository.findById(user.getId());
	}

	@PutMapping(value = "/update/{id}/{name}")
	public User update(@PathVariable("id") final String id, @PathVariable("name") String name) {
		repository.update(new User(id, name, 1000L));
		return repository.findById(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
		repository.delete(id);
		return getAllUser();
	}

	@GetMapping("/all")
	public Map<String, User> getAllUser() {
		Map<String, User> findAll = repository.findAll();
		return findAll;
	}
}
