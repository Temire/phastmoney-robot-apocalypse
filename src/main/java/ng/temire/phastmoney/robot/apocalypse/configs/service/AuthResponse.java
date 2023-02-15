package ng.temire.phastmoney.robot.apocalypse.configs.service;

import lombok.*;
import ng.temire.phastmoney.robot.apocalypse.configs.User;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    User user;
    String token;
    String message;
}
