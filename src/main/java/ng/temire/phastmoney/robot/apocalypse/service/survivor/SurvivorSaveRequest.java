package ng.temire.phastmoney.robot.apocalypse.service.survivor;

import ng.temire.phastmoney.robot.apocalypse.domain.embeddables.Location;
import lombok.Builder;
import lombok.Data;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:35
 */
@Data
public class SurvivorSaveRequest {
    private String firstName;
    private  String lastName;
    private String gender;
    private Location location;
    private int age;

}
