package org.okten.springboot_demos.hw_springBootDemo_task2.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.okten.springboot_demos.hw_springBootDemo_task2.CarService;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel1DTO;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel2DTO;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel3DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    // 1. GET /cars (Повертає Level 3)
    @GetMapping("")
    public ResponseEntity<List<CarLevel3DTO>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    // 2. GET /cars/{id} (Повертає Level 1 або 404 якщо немає)
    @GetMapping("/{id}")
    public ResponseEntity<CarLevel1DTO> getCarById(@PathVariable Long id) {
        return carService.getCarById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 3. POST /cars (Приймає Level 2 з валідацією, повертає 201 Сreated)
    @PostMapping("")
    public ResponseEntity<CarLevel1DTO> createCar(@RequestBody @Valid CarLevel2DTO carLevel2DTO) {
        CarLevel1DTO created = carService.createCar(carLevel2DTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // 4. DELETE /cars/{id} (Повертає 204 No Content якщо видалено, або 404)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        boolean deleted = carService.deleteCar(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 5. GET /cars/power/{power} (Повертає Level 2)
    @GetMapping("/power/{power}")
    public ResponseEntity<List<CarLevel2DTO>> getCarsByPower(@PathVariable Integer power) {
        return new ResponseEntity<>(carService.getCarsByPower(power), HttpStatus.OK);
    }

    // 6. GET /cars/producer/{producer} (Повертає Level 2)
    @GetMapping("/producer/{producer}")
    public ResponseEntity<List<CarLevel2DTO>> getCarsByProducer(@PathVariable String producer) {
        return new ResponseEntity<>(carService.getCarsByProducer(producer), HttpStatus.OK);
    }

}
