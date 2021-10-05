package com.invenia.userservice.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
  @Id
  private String email;
  private String password;
  private String name;
  private LocalDateTime createdAt;
}
