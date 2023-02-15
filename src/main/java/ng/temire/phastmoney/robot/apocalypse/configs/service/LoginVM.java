package ng.temire.phastmoney.robot.apocalypse.configs.service;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginVM implements Serializable {
    String username, password;
}

