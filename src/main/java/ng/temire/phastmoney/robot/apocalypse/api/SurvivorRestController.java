package ng.temire.phastmoney.robot.apocalypse.api;

import ng.temire.phastmoney.robot.apocalypse.domain.embeddables.Location;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryDto;
import ng.temire.phastmoney.robot.apocalypse.service.survivor.SurvivorDto;
import ng.temire.phastmoney.robot.apocalypse.service.survivor.SurvivorSaveRequest;
import ng.temire.phastmoney.robot.apocalypse.service.survivor.SurvivorService;
import ng.temire.phastmoney.robot.apocalypse.util.Constants;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ng.temire.phastmoney.robot.apocalypse.util.Constants.*;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 13:15
 */
@RestController
@RequestMapping("phastmoney/apocalypse/survivor")
@RequiredArgsConstructor
public class SurvivorRestController {
    private final SurvivorService survivorService;

    @Operation(summary = ADD_SURVIVOR_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ADD_SURVIVOR_DESCRIPTION,
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SurvivorDto.class)) })})
    @PostMapping("/save")
    public ResponseEntity<SurvivorDto> saveSurvivor(@RequestBody SurvivorSaveRequest survivorSaveRequest){
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(survivorService.saveSurvivor(survivorSaveRequest));
    }

    @Operation(summary = UPDATE_LOCATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = UPDATE_LOCATION_DESCRIPTION,
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SurvivorDto.class)) }),
            @ApiResponse(responseCode = "404", description = SURVIVOR_NOT_FOUND,
                    content = @Content) })
    @PutMapping("/update/{survivorId}")
    public ResponseEntity<SurvivorDto>  updateLocation(@PathVariable Long survivorId,
                                                       @RequestBody Location location){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(survivorService.updateLocation(survivorId,location));
    }
    @GetMapping("/report-infection/{infectionStatus}")
    @Operation(summary = "Get Survivors By Infection Status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Survivors found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SurvivorDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Survivors not found",
                    content = @Content) })
    public ResponseEntity<List<SurvivorDto>> getSurvivorsByInfectionStatus(@PathVariable InfectionStatus infectionStatus){
        return ResponseEntity.ok(survivorService.getSurvivorsByInfectionStatus(infectionStatus));
    }
}
