package ng.temire.phastmoney.robot.apocalypse.service.robot.impl;

import ng.temire.phastmoney.robot.apocalypse.service.robot.Robot;
import ng.temire.phastmoney.robot.apocalypse.service.robot.RobotDto;
import ng.temire.phastmoney.robot.apocalypse.service.robot.RobotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ng.temire.phastmoney.robot.apocalypse.util.Constants.ROBOTS_URL;

/**
 * @author Temire Emmanuel
 * @created 13/02/2023 - 10:10
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RobotServiceImpl implements RobotService {

    private final WebClient webClient;

    @Override
    public RobotDto listAllRobots(){

        Robot[] robotsArray = webClient.get()
                .retrieve()
                .bodyToMono(Robot[].class)
                .block();

        List<Robot> flyingRobots = Arrays.stream(robotsArray)
                .filter(robot -> robot.getCategory().equalsIgnoreCase("Flying"))
                .collect(Collectors.toList());

        List<Robot> landRobots = Arrays.stream(robotsArray)
                .filter(robot -> robot.getCategory().equalsIgnoreCase("Land"))
                .collect(Collectors.toList());

        RobotDto robotDto = RobotDto.builder()
                .numberOfFlyingRobots(flyingRobots.stream().count())
                .numberOfLandRobots(landRobots.stream().count())
                .flyingRobots(flyingRobots)
                .landRobots(landRobots)
                .build();
        return robotDto;
    }
}
