package com.demo.graphql.repository;

import com.demo.graphql.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

  private final Map<String, User> database = new HashMap<>();

  public UserRepository() {
    database.put("1", new User("1", "Bryan", "bryan@email.com"));
    database.put("2", new User("2", "Ana", "ana@email.com"));
  }

  public User findById(String id) {
    return database.get(id);
  }

  public List<User> findAll() {
    return new ArrayList<>(database.values());
  }

  public List<User> findByFilters(String name, String email) {
    return database.values()
      .stream()
      .filter(user ->
        (name == null || user.getName().equalsIgnoreCase(name)) &&
          (email == null || user.getEmail().equalsIgnoreCase(email))
      )
      .toList();
  }
}
