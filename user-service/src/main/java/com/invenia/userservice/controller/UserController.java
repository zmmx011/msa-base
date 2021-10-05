package com.invenia.userservice.controller;

import com.invenia.userservice.entity.User;
import com.invenia.userservice.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("user-service/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @GetMapping("/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    return ResponseEntity.ok().body(userService.getUserByEmail(email));
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.createUser(user));
  }

  @PutMapping("/")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.updateUser(user));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<User> deleteUser(@PathVariable String email) {
    userService.deleteUser(email);
    return ResponseEntity.ok().build();
  }
}
