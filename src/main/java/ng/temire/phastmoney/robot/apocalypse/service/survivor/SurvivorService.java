package ng.temire.phastmoney.robot.apocalypse.service.survivor;

import ng.temire.phastmoney.robot.apocalypse.domain.embeddables.Location;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;

import java.util.List;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:35
 */
public interface SurvivorService {

    /**
     * This method creates/saves Survivor from SurvivorSaveRequest
     * @param survivorSaveRequest
     * @return SurvivorDto
     */
    SurvivorDto saveSurvivor(SurvivorSaveRequest survivorSaveRequest);

    /**
     * This method updates the Survivor Location
     * @param survivorId unique identifier of Survivor
     * @param location location to update the Survivor with
     * @return SurvivorDto
     */
    SurvivorDto updateLocation(Long survivorId,Location location);

    /**
     * This method fetches survivors by infection status which can
     * either be INFECTED or NON_INFECTED
     * @param infectionStatus
     * @return List<SurvivorDto>
     */
    List<SurvivorDto> getSurvivorsByInfectionStatus(InfectionStatus infectionStatus);

    /**
     * This method calculates percentage of infected or non_infected survivors
     * @param infectedStatus
     * @return Double
     */
    Double getInfectedOrNonInfectedPercentage(InfectionStatus infectedStatus);

}
