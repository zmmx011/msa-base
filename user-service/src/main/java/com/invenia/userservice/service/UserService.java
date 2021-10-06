package com.invenia.userservice.service;

import com.invenia.userservice.entity.User;
import com.invenia.userservice.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String email) {
    userRepository.deleteByEmail(email);
  }

  /**
   * Locates the user based on the username. In the actual implementation, the search may possibly be case sensitive, or
   * case insensitive depending on how the implementation instance is configured. In this case, the
   * <code>UserDetails</code> object that comes back may have a username that is of a different case than what was
   * actually requested..
   *
   * @param email the email identifying the user whose data is required.
   * @return a fully populated user record (never <code>null</code>)
   * @throws UsernameNotFoundException if the user could not be found or the user has no GrantedAuthority
   */
  @Override
  public User loadUserByUsername(String email) throws UsernameNotFoundException {
    return getUserByEmail(email);
  }
}
