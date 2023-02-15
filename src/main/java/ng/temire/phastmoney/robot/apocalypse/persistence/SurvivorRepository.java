package ng.temire.phastmoney.robot.apocalypse.persistence;

import ng.temire.phastmoney.robot.apocalypse.domain.Survivor;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:34
 */
@Repository
public interface SurvivorRepository extends JpaRepository<Survivor,Long> {
    Optional<List<Survivor>> getSurvivorsByInfectionStatus(InfectionStatus infectionStatus);

    Integer countAllByInfectionStatus(InfectionStatus infectionStatus);

    Long countByInfectionStatus(InfectionStatus infectionStatus);
}
