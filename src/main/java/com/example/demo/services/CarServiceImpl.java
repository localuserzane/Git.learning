package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepo carRepo;
	
	@Override
	public ArrayList<Car> selectAll() {
		ArrayList<Car> tempList = new ArrayList<Car>();
		for(Car c:carRepo.findAll()) {
			tempList.add(c);
		}
		return tempList;
	}

	@Override
	public Car selectById(int id) {
		Car carTemp = carRepo.findById(id).get(); //get car with id 1
		if(carTemp != null)
			return carTemp;
		return null;
	}

	@Override
	public boolean insertNewCar(Car car) {
		//TODO verify if car is already in repo
		//if not, save, return true
		//if yes, return false
		if(car == null || carRepo.existsById(car.getID()))
			return false;
		else {
			carRepo.save(car);
			return true;
		}
	}

	@Override
	public boolean updateCarByID(Car car, int id) {
		System.out.println("INCOMING ----" +id);
		
		if(car != null && carRepo.existsById(id)) {
			Car carTemp = carRepo.findById(id).get();
			System.out.println("TEMP----" +carTemp.getID());
			carTemp.setColor(car.getColor());
			carTemp.setEngine(car.getEngine());
			carTemp.setSpeed(car.getSpeed());
			carTemp.setYear(car.getYear());
			carRepo.save(carTemp);
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteCarByID(int id) {
		if(id > -1 && carRepo.existsById(id)) {
			carRepo.deleteById(id);
			return true;
		}else
			return false;
	}

	@Override
	public boolean deleteCarByObject(Car car) {
		if(car != null && carRepo.existsById(car.getID())) {
			carRepo.delete(car);
			return true;
		} else
			return false;
	}

}
