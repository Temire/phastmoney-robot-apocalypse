package ng.temire.phastmoney.robot.apocalypse.service.survivor;

import ng.temire.phastmoney.robot.apocalypse.domain.Survivor;
import ng.temire.phastmoney.robot.apocalypse.domain.embeddables.Location;
import ng.temire.phastmoney.robot.apocalypse.util.enums.Gender;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 16:07
 */

@Data
public class SurvivorDto {
    private Long id;
    private String firstName;
    private  String lastName;
    private Gender gender;
    private InfectionStatus infectionStatus;
    private Location location;
    private int age;
    private int infectionReportTracker;
    private LocalDateTime dateCreated;



}
