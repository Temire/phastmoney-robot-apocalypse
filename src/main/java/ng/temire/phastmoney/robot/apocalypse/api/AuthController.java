package ng.temire.phastmoney.robot.apocalypse.api;

import lombok.RequiredArgsConstructor;
import ng.temire.phastmoney.robot.apocalypse.configs.service.AuthResponse;
import ng.temire.phastmoney.robot.apocalypse.configs.service.LoginVM;
import ng.temire.phastmoney.robot.apocalypse.configs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phastmoney/apocalypse/security")
public class AuthController {

    @Lazy
    @Autowired
    UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginVM loginVM) {
        System.out.println("Login  -->  "+loginVM);
        AuthResponse response = userService.signin(loginVM.getUsername(), loginVM.getPassword());
        if(response.getUser()!=null) return new ResponseEntity<>(response, HttpStatus.OK);
        else return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
