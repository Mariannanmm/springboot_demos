package org.okten.springboot_demos.hw_springBootDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    // 1. GET http://localhost:8080/cars
    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    // 2. GET http://localhost:8080/cars/1
    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST http://localhost:8080/cars
    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    // 4. DELETE http://localhost:8080/cars/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (carService.deleteCar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // 5. GET http://localhost:8080/cars/power/150
    @GetMapping("/power/{value}")
    public ResponseEntity<List<Car>> getByPower(@PathVariable Integer value) {
        return ResponseEntity.ok(carService.getCarsByPower(value));
    }

    // 6.  GET http://localhost:8080/cars/producer/BMW
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<Car>> getByProducer(@PathVariable String value) {
        return ResponseEntity.ok(carService.getCarsByProducer(value));
    }
}
