package ng.temire.phastmoney.robot.apocalypse.service.infectionrecord;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 21:36
 */
@Data
public class InfectionRecordDto {
    private Long id;
    private String reportedBy;
    private Long reportedById;
    private String survivorReported;
    private Long survivorReportedId;
    private LocalDateTime dateReported;

}
