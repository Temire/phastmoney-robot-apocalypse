package ng.temire.phastmoney.robot.apocalypse.service.inventory.impl;

import ng.temire.phastmoney.robot.apocalypse.domain.Inventory;
import ng.temire.phastmoney.robot.apocalypse.domain.Survivor;
import ng.temire.phastmoney.robot.apocalypse.errohandling.InventoryNotFoundException;
import ng.temire.phastmoney.robot.apocalypse.errohandling.InvalidRequestException;
import ng.temire.phastmoney.robot.apocalypse.errohandling.SurvivorNotFoundException;
import ng.temire.phastmoney.robot.apocalypse.persistence.InventoryRepository;
import ng.temire.phastmoney.robot.apocalypse.persistence.SurvivorRepository;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryDto;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryRequest;
import ng.temire.phastmoney.robot.apocalypse.service.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 17:39
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final ModelMapper modelMapper;
    private final InventoryRepository inventoryRepository;
    private final SurvivorRepository survivorRepository;

    @Override
    public InventoryDto saveInventory(InventoryRequest inventoryRequest) {
        Survivor survivor = survivorRepository.findById(inventoryRequest.getSurvivorId()).orElseThrow(
                () -> new SurvivorNotFoundException(
                        String.format("Survivor with id %s was not found", inventoryRequest.getSurvivorId())
                )
        );
        if (inventoryRequest.getQuantity() < 0){
            throw new InvalidRequestException(
                    String.format("Quantity, %s, cannot be negative", inventoryRequest.getQuantity())
            );
        }

        Inventory inventory = Inventory.builder()
                .inventoryType(inventoryRequest.getInventoryType())
                .quantity(inventoryRequest.getQuantity())
                .survivor(survivor)
                .activeStatus(true)
                .build();

        return convertInventoryToDto(inventoryRepository.save(inventory));
    }
    @Override
    public List<InventoryDto> getInventoryBySurvivor(Long survivorId) {
        Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(
                () -> new SurvivorNotFoundException(
                        String.format("Survivor with id %s was not found", survivorId)
                )
        );
        List<Inventory> inventoryBySurvivor = inventoryRepository.getInventoryBySurvivor(survivor);
        return inventoryBySurvivor
                .stream()
                .map(inventory -> convertInventoryToDto(inventory))
                .collect(Collectors.toList());
    }

    @Override
    public InventoryDto updateInventory(Long inventoryId, InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(
                () -> new InventoryNotFoundException(
                        String.format("Survivor with id %s was not found", inventoryId)
                )
        );
        inventory.setInventoryType(inventoryRequest.getInventoryType());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setActiveStatus(inventoryRequest.isActiveStatus());
        return convertInventoryToDto(inventoryRepository.save(inventory));
    }

    private InventoryDto convertInventoryToDto(Inventory inventory) {
        InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
        return inventoryDto;
    }
}
