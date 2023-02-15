package ng.temire.phastmoney.robot.apocalypse.service.robot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Temire Emmanuel
 * @created 13/02/2023 - 09:58
 */
@Data
@Builder
public class RobotDto {
    Long numberOfLandRobots;
    Long numberOfFlyingRobots;
    List<Robot> flyingRobots;
    List<Robot> landRobots;
}
