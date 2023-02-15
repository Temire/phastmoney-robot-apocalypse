package ng.temire.phastmoney.robot.apocalypse.domain.embeddables;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:38
 */
@Data
@Embeddable
public class Location {
    private double longitude;
    private double latitude;
}
