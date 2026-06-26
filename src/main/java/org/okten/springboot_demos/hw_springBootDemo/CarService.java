package org.okten.springboot_demos.hw_springBootDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    public Car createCar(Car car) {
        car.setId(idCounter++);
        cars.add(car);
        return car;
    }

    public boolean deleteCar(Long id) {
        return cars.removeIf(car -> car.getId().equals(id));
    }

    public List<Car> getCarsByPower(Integer power) {
        return cars.stream()
                .filter(car -> car.getPower().equals(power))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByProducer(String producer) {
        return cars.stream()
                .filter(car -> car.getProducer().equalsIgnoreCase(producer))
                .collect(Collectors.toList());
    }
}
