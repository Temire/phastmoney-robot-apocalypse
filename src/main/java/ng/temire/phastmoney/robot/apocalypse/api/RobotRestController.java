package ng.temire.phastmoney.robot.apocalypse.api;

import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryDto;
import ng.temire.phastmoney.robot.apocalypse.service.robot.RobotDto;
import ng.temire.phastmoney.robot.apocalypse.service.robot.RobotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.CommunicationException;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 18:31
 */
@RestController
@RequestMapping("phastmoney/apocalypse")
@RequiredArgsConstructor
public class RobotRestController {
    private final RobotService robotService;
    @GetMapping("/robots")
    @Operation(summary = "Get Robots")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Robots found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RobotDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Robots not found",
                    content = @Content) })
    public ResponseEntity<Object> getAllRobots() throws CommunicationException {
        try {
            return ResponseEntity.ok().body(robotService.listAllRobots());
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
