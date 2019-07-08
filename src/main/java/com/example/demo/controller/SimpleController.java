package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;

@Controller
public class SimpleController {

	@Autowired
	CarRepo carRepo;
	
	@GetMapping(value="/testdata")
	public String testdata() {
		/*
		Car car1 = new Car("Diesel", 240, 1989, "Yellow");
		Car car2 = new Car("Gasoline", 280, 2017, "White");
		Car car3 = new Car("Hybrid", 210, 2001, "Blue");
		
		carRepo.save(car1);
		carRepo.save(car2);
		carRepo.save(car3);
		
		//SELECT ALL
		for(Car c:carRepo.findAll()) {
			System.out.println(c.getEngine() + " " + c.getColor());
		}
		
		//SELECT ONE
		Car carTemp = carRepo.findById(1).get(); //get car with id 1
		if(carTemp != null)
			System.out.println(carTemp.getEngine() + " " + carTemp.getColor());
		
		//UPDATE
		Car carTempUpdate = carRepo.findById(1).get();
		if(carTempUpdate!=null) {
			carTempUpdate.setColor("Pink");
			carRepo.save(carTempUpdate);
		}
		
		//DELETE
		Car carTempDelete = carRepo.findById(1).get();
		if(carTempDelete != null)
			carRepo.delete(carTempDelete);
		
		//FIND BY YEAR
		ArrayList<Car> carsYear2019 = carRepo.findByYear(2017);
		for (int i = 0; i < carsYear2019.size(); i++) {
			System.out.println(carsYear2019.toString());
		}
		
		*/
		return "testdata";
	}
}
