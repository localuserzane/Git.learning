package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Car;
import com.example.demo.services.CarServiceImpl;

@Controller
@RequestMapping(value="/car")
public class CarController {
	@Autowired
	CarServiceImpl carServiceImpl; 

	@GetMapping(value = "/allcarsview")
	public String allcarsview(Model model) {

		model.addAttribute("carlist", carServiceImpl.selectAll());
		return "allcarsview";
	}
	
	@GetMapping(value = "/allcarsview/{id}")
	public String allcarsviewbyid(@PathVariable(name="id") int id, Model model) {

		model.addAttribute("object", carServiceImpl.selectById(id));
		return "allcarsview";
	}
	
	@GetMapping(value = "/addcar") // localhost:8080/addcar
	public String addcarGet(Car car) {

		return "addcar"; // addcar.html
	}
	
	@PostMapping(value = "/addcar") // after submit button pressed
	public String addcarPost(Car car) { // filled car object data
		carServiceImpl.insertNewCar(car);
		return "redirect:/car/allcarsview";
	}
	
	@GetMapping(value = "/update/{id}")
	public String updateCarGet(@PathVariable(name = "id") int id, Model model) {
		model.addAttribute("car", carServiceImpl.selectById(id));
		return "update";
	}
	
	@PostMapping(value = "/update/{id}")
	public String updateCarPost(@PathVariable(name = "id") int id, Car car) {
		carServiceImpl.updateCarByID(car, id);
		return "redirect:/car/allcarsview";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteCarGet(@PathVariable(name = "id") int id) {
		carServiceImpl.deleteCarByID(id);
		return "redirect:/car/allcarsview";
	}
}//komentars lai butu izmainas
