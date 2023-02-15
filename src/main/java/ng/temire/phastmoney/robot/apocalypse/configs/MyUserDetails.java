package ng.temire.phastmoney.robot.apocalypse.configs;

import lombok.RequiredArgsConstructor;
import ng.temire.phastmoney.robot.apocalypse.configs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Lazy
    @Autowired
    UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   User retrievedUser = service.getUser(username);

    if (retrievedUser == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(retrievedUser.getPassword())//
        .authorities(retrievedUser.getRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
