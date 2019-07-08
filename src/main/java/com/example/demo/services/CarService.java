package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Car;

public interface CarService {
	//public abstract static - default for all interface methods 
	
	ArrayList<Car> selectAll();
	Car selectById(int id);
	boolean insertNewCar(Car car);
	boolean updateCarByID(Car car, int id);
	boolean deleteCarByID(int id);
	boolean deleteCarByObject(Car car);
	
	
	

}
