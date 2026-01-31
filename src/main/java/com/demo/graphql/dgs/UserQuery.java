package com.demo.graphql.dgs;

import com.demo.graphql.model.User;
import com.demo.graphql.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@DgsComponent
@Slf4j
public class UserQuery {

  private final UserService userService;

  //Inyeccion de dependencia
  public UserQuery(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery
  public String hello() {
    return "Hola desde GraphQL";
  }

  @DgsQuery
  public User user(@InputArgument String id) {
    log.info("Buscando usuario con id={}", id);
    return userService.getUserById(id);
  }

  @DgsQuery
  public List<User> users(
    @InputArgument String name,
    @InputArgument String email
  ) {
    log.info("Buscando usuarios con filtros name={}, email={}", name, email);
    return userService.getUsers(name, email);
  }
}
