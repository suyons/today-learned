package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

import java.util.HashMap;

@RestController
public class CarController {
	@Autowired
	private CarRepository repository;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}

	@RequestMapping("/car/{brand}")
	public Iterable<Car> getCarsByBrand(@PathVariable String brand) {
		return repository.findByBrand(brand);
	}

	@PostMapping(value = "/car/color")
	public Iterable<Car> getCarsByColor(@RequestBody HashMap<String, String> color) {
		return repository.findByColor(color.get("color"));
	}
}
