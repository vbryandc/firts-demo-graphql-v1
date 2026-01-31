package com.demo.graphql.service;

import com.demo.graphql.model.User;
import com.demo.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getUserById(String id) {
    return repository.findById(id);
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public List<User> getUsers(String name, String email) {
    return repository.findByFilters(name, email);
  }
}
