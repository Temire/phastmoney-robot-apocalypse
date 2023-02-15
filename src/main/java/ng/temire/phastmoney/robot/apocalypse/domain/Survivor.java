package ng.temire.phastmoney.robot.apocalypse.domain;

import ng.temire.phastmoney.robot.apocalypse.domain.embeddables.Location;
import ng.temire.phastmoney.robot.apocalypse.util.enums.Gender;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:15
 */

@Entity
@Table(name = "survivor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private InfectionStatus infectionStatus;

    @Embedded
    private Location location;

    private LocalDate dateCreated;

    private int age;

    private Integer infectionReportTracker;


}
