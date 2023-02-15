package ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.impl;

import ng.temire.phastmoney.robot.apocalypse.domain.InfectionRecord;
import ng.temire.phastmoney.robot.apocalypse.domain.Survivor;
import ng.temire.phastmoney.robot.apocalypse.errohandling.SurvivorNotFoundException;
import ng.temire.phastmoney.robot.apocalypse.persistence.InfectionRecordRepository;
import ng.temire.phastmoney.robot.apocalypse.persistence.SurvivorRepository;
import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordDto;
import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordRequest;
import ng.temire.phastmoney.robot.apocalypse.service.infectionrecord.InfectionRecordService;
import ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

import static ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus.INFECTED;
import static ng.temire.phastmoney.robot.apocalypse.util.enums.InfectionStatus.NON_INFECTED;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 21:07
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class InfectionRecordServiceImpl implements InfectionRecordService {

    private final InfectionRecordRepository infectionRecordRepository;
    private final SurvivorRepository survivorRepository;
    private final ModelMapper modelMapper;
    @Override
    public InfectionRecordDto reportInfection(InfectionRecordRequest infectionRecordRequest) {
        requireNonNull(infectionRecordRequest,"InfectionRecordRequest cannot be null");
        log.info("Reporting survivor infection , infectionRecordRequest = {}", infectionRecordRequest);
        Survivor survivorReported = survivorRepository.findById(infectionRecordRequest.getSurvivorReportedId())
                 .orElseThrow(
                         () -> new SurvivorNotFoundException(
                                 format("Survivor being reported with id %s not found",
                                         infectionRecordRequest.getSurvivorReportedId())
                         )
                 );

        Survivor reportedBy = survivorRepository.findById(infectionRecordRequest.getReportedById())
                .orElseThrow(
                        () -> new SurvivorNotFoundException(
                                format("Survivor Reporting Infection with id %s not found",
                                        infectionRecordRequest.getReportedById())
                        )
                );

        InfectionRecord infectionRecord = InfectionRecord.builder()
                .reportedById(reportedBy.getId())
                .reportedBy(reportedBy.getFirstName())
                .survivorReportedId(survivorReported.getId())
                .survivorReported(survivorReported.getFirstName())
                .dateReported(LocalDateTime.now())
                .build();
        if (Objects.equals(survivorReported.getInfectionStatus(), NON_INFECTED)){
            survivorReported.setInfectionReportTracker(survivorReported.getInfectionReportTracker() + 1);
        }

        if (survivorReported.getInfectionReportTracker() == 3) {
            survivorReported.setInfectionStatus(INFECTED);
        }

        survivorRepository.save(survivorReported);

        return convertInfectionRecordToDto(infectionRecordRepository.save(infectionRecord));
    }
    private InfectionRecordDto convertInfectionRecordToDto(InfectionRecord infectionRecord) {
        InfectionRecordDto infectionRecordDto = modelMapper.map(infectionRecord, InfectionRecordDto.class);
        return infectionRecordDto;
    }
}
