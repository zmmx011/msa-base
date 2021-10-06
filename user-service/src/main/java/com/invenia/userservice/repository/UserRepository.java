package com.invenia.userservice.repository;

import com.invenia.userservice.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);

  Optional<User> deleteByEmail(String email);
}
