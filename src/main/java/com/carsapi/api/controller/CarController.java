package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    @Autowired
    private CarRepository repository;

    @PostMapping
    public Object create(@RequestBody CarDTO req){
      repository.save(new Car(req));
      return req;
    }

    @GetMapping
    public List<Car> listAll(){
      return repository.findAll();
    }
}
