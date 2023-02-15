package ng.temire.phastmoney.robot.apocalypse.configs.service;

import ng.temire.phastmoney.robot.apocalypse.configs.JwtTokenProvider;
import ng.temire.phastmoney.robot.apocalypse.configs.User;
import ng.temire.phastmoney.robot.apocalypse.configs.constants.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserService {

    @Lazy
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    public UserService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public User getUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_CLIENT);
        user.setRoles(roles);
        return user;
    }

    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(username+"@"+1990);
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_CLIENT);
        user.setRoles(roles);
        return user;
    }

    public AuthResponse signin(String username, String password) {
        System.out.println("AuthResponse  ");
        if (username.equalsIgnoreCase("phastmoney") && password.equalsIgnoreCase("apocalypse")) {
            User userDTO = getUser(username, password);
            String token = jwtTokenProvider.createToken(username, userDTO.getRoles());
            AuthResponse authResponse = new AuthResponse(userDTO, token, "User Log in Successful!");
            return authResponse;
        }
        else return new AuthResponse(null, null, "User Log in not Successful!");
    }
}
