package com.demo.graphql.dgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.Map;

@DgsComponent
public class HelloDataFetcher {

  @DgsQuery
  public String hello() {
    return "Hola desde GraphQL con DGS 🚀";
  }

  @DgsQuery
  public Map<String, Object> user(@InputArgument String id) {
    return Map.of(
      "id", id,
      "name", "Bryan",
      "email", "bryan@email.com"
    );
  }
}
