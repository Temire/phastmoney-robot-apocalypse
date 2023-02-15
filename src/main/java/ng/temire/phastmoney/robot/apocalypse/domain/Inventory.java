package ng.temire.phastmoney.robot.apocalypse.domain;

import ng.temire.phastmoney.robot.apocalypse.util.enums.InventoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:39
 */
@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Survivor survivor;
    @Enumerated(EnumType.STRING)
    private InventoryType inventoryType;

    private long quantity;

    private boolean activeStatus;
}
