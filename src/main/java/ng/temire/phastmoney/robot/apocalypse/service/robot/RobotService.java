package ng.temire.phastmoney.robot.apocalypse.service.robot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.CommunicationException;

/**
 * @author Temire Emmanuel
 * @created 13/02/2023 - 10:07
 */
public interface RobotService {

    /**
     * retrieves a list of robots
     * @return
     */
    RobotDto listAllRobots();

}
