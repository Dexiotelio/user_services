package com.ecommerce.demo.repositories.interfaces;

import com.ecommerce.demo.model.Client;
import com.ecommerce.demo.model.Person;
import com.ecommerce.demo.util.Result;
import io.vavr.control.Try;

public interface PersonQueryRepository {
  Person findById(Long id);
  Client findByUsername(String username);
  Try<Result<Boolean>> exists(String email);
}
