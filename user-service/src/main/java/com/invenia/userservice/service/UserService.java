package com.invenia.userservice.service;

import com.invenia.userservice.entity.User;
import com.invenia.userservice.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
    return userRepository.getById(email);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String email) {
    userRepository.deleteById(email);
  }
}
