package ng.temire.phastmoney.robot.apocalypse.service.inventory;

import ng.temire.phastmoney.robot.apocalypse.util.enums.InventoryType;
import lombok.Data;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 17:28
 */
@Data
public class InventoryDto {

    private Long id;
    private Long survivorId;
    private InventoryType inventoryType;
    private long quantity;
    private boolean activeStatus;

    public String getQuantity(){
        return quantity + inventoryType.getUnitOfMeasure();
    }
}
