package ng.temire.phastmoney.robot.apocalypse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 20:56
 */
@Entity
@Table(name = "infection_record")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InfectionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportedBy;
    private Long reportedById;
    private String survivorReported;
    private Long survivorReportedId;
    private LocalDateTime dateReported;
}
