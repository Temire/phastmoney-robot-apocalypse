package ng.temire.phastmoney.robot.apocalypse.persistence;

import ng.temire.phastmoney.robot.apocalypse.domain.InfectionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 21:03
 */
@Repository
public interface InfectionRecordRepository extends JpaRepository<InfectionRecord, Long> {
}
