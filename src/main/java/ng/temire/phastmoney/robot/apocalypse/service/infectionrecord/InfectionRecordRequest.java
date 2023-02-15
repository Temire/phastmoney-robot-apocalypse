package ng.temire.phastmoney.robot.apocalypse.service.infectionrecord;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 21:06
 */
@Data
public class InfectionRecordRequest {
    private Long reportedById;
    private Long survivorReportedId;
    private LocalDateTime dateReported;

}
