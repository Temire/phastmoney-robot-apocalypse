package ng.temire.phastmoney.robot.apocalypse.service.infectionrecord;

import ng.temire.phastmoney.robot.apocalypse.domain.InfectionRecord;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 21:05
 */
public interface
InfectionRecordService {
    /**
     * This method report infection of survivor using InfectionRecordRequest
     * @param infectionRecordRequest
     * @return InfectionRecordDto
     */
    InfectionRecordDto reportInfection(InfectionRecordRequest infectionRecordRequest);
}
