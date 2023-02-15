package ng.temire.phastmoney.robot.apocalypse.service.inventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 17:27
 */
public interface InventoryService {

    /**
     *This method gets Inventory page using survivor id
     * @param survivorId unique identify of Survivor
     * @return List<InventoryDto> list of InventoryDto
     */
    List<InventoryDto> getInventoryBySurvivor(Long survivorId);

    /**
     *This method saves Inventory  using InventoryRequest
     * @param inventoryRequest
     * @return InventoryDto
     */
    InventoryDto saveInventory(InventoryRequest inventoryRequest);

    /**
     * This method updates inventory using InventoryRequest after searching for it with the
     * inventory unique id
     * @param inventoryId
     * @param inventoryDto
     * @return InventoryDto
     */
    InventoryDto updateInventory(Long inventoryId,InventoryRequest inventoryDto);
}
