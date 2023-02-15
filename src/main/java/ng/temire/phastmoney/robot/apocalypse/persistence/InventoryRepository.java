package ng.temire.phastmoney.robot.apocalypse.persistence;

import ng.temire.phastmoney.robot.apocalypse.domain.Inventory;
import ng.temire.phastmoney.robot.apocalypse.domain.Survivor;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryDto;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 17:27
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Page<Inventory> getInventoryBySurvivor(Survivor survivor, Pageable pageable);

    List<Inventory> getInventoryBySurvivor(Survivor survivor);
}
