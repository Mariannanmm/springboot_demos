package org.okten.springboot_demos.hw_springBootDemo_task2;

import lombok.RequiredArgsConstructor;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel1DTO;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel2DTO;
import org.okten.springboot_demos.hw_springBootDemo_task2.dto.CarLevel3DTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    //************************************hw2******************************//
    // GET /cars
    //public List<Car> getAllCars() {
    //    return carRepository.findAll();
    //}

    // GET /cars/{id}
    //public Optional<Car> getCarById(Long id) {
    //    return carRepository.findById(id);
    //}

    // POST /cars
    //public Car createCar(Car car) {
    //    return carRepository.save(car);
    //}

    // DELETE /cars/{id}
    //public boolean deleteCar(Long id) {
    //    if (carRepository.existsById(id)) {
    //        carRepository.deleteById(id);
    //        return true;
    //    }
    //    return false;
    //}

    // GET /cars/power/{value}
    //public List<Car> getCarsByPower(Integer power) {
    //    return carRepository.findAllByPower(power);
    //}

    // GET /cars/producer/{value}
    //public List<Car> getCarsByProducer(String producer) {
    //    return carRepository.findByProducerIgnoreCase(producer);
    //}
    //*******************************************************************//
    // GET /cars -> повертає Level 3 (model, producer)
    public List<CarLevel3DTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> new CarLevel3DTO(car.getModel(), car.getProducer()))
                .collect(Collectors.toList());
    }

    // GET /cars/{id} -> повертає Level 1 (id, model, producer, power)
    public Optional<CarLevel1DTO> getCarById(Long id) {
        return carRepository.findById(id)
                .map(car -> new CarLevel1DTO(car.getId(), car.getModel(), car.getProducer(), car.getPower()));
    }

    // POST /cars -> приймає Level2DTO, зберігає і повертає створений об'єкт як Level1DTO
    public CarLevel1DTO createCar(CarLevel2DTO dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setProducer(dto.getProducer());
        car.setPower(dto.getPower());

        Car savedCar = carRepository.save(car);
        return new CarLevel1DTO(savedCar.getId(), savedCar.getModel(), savedCar.getProducer(), savedCar.getPower());
    }

    // DELETE /cars/{id}
    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // GET /cars/power/{value} -> повертає Level 2 (model, producer, power)
    public List<CarLevel2DTO> getCarsByPower(Integer power) {
        return carRepository.findAllByPower(power).stream()
                .map(car -> new CarLevel2DTO(car.getModel(), car.getProducer(), car.getPower()))
                .collect(Collectors.toList());
    }

    // GET /cars/producer/{value} -> повертає Level 2 (model, producer, power)
    public List<CarLevel2DTO> getCarsByProducer(String producer) {
        return carRepository.findByProducerIgnoreCase(producer).stream()
                .map(car -> new CarLevel2DTO(car.getModel(), car.getProducer(), car.getPower()))
                .collect(Collectors.toList());
    }


}
