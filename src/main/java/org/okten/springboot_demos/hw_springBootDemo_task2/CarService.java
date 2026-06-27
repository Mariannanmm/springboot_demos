package org.okten.springboot_demos.hw_springBootDemo_task2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    // GET /cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // GET /cars/{id}
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // POST /cars
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    // DELETE /cars/{id}
    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // GET /cars/power/{value}
    public List<Car> getCarsByPower(Integer power) {
        return carRepository.findAllByPower(power);
    }

    // GET /cars/producer/{value}
    public List<Car> getCarsByProducer(String producer) {
        return carRepository.findByProducerIgnoreCase(producer);
    }
}
