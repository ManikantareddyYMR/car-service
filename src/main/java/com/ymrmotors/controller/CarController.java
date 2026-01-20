package com.ymrmotors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ymrmotors.model.Car;
import com.ymrmotors.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    
    @Autowired
    private CarRepository carRepository;
    
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }
    
@PutMapping("/{id}")
public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
    return carRepository.findById(id)
            .map(car -> {
                car.setMake(carDetails.getMake());
                car.setModel(carDetails.getModel());
                car.setManufactureYear(carDetails.getManufactureYear()); // 👈 Keep this
                car.setPrice(carDetails.getPrice());
                car.setMileage(carDetails.getMileage());
                car.setColor(carDetails.getColor());
                return ResponseEntity.ok(carRepository.save(car));
            })
            .orElse(ResponseEntity.notFound().build());
}

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        return carRepository.findById(id)
                .map(car -> {
                    carRepository.delete(car);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}