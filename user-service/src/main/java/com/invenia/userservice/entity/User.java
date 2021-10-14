package com.invenia.userservice.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long code;

  @Column(unique = true)
  private String email;
  private String password;
  private String name;
  private LocalDateTime createdAt;

}
