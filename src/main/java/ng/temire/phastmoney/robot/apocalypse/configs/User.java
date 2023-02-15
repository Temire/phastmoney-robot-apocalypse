package ng.temire.phastmoney.robot.apocalypse.configs;

import lombok.*;
import ng.temire.phastmoney.robot.apocalypse.configs.constants.Role;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private String username;
    private String password;
    private List<Role> roles;
}
