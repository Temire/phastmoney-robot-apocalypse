package ng.temire.phastmoney.robot.apocalypse.api;

import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordDto;
import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordRequest;
import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Temire Emmanuel
 * @created 13/02/2023 - 09:00
 */
@RestController
@RequestMapping("phastmoney/apocalypse/report-infection")
@RequiredArgsConstructor
public class InfectionRecordRestController {
    private final InfectionRecordService infectionRecordService;

    @Operation(summary = "Report Infection Survivor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Report saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InfectionRecordDto.class)) })})
    @PostMapping("/save")
    public ResponseEntity<InfectionRecordDto> reportInfection(@RequestBody InfectionRecordRequest infectionRecordRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(infectionRecordService.reportInfection(infectionRecordRequest));
    }
}
