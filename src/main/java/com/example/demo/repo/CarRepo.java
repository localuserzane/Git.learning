package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Car;

public interface CarRepo extends CrudRepository<Car, Integer>{
	
	ArrayList<Car> findByYear(int year);
	ArrayList<Car> findByYearAndSpeed(int year, int speed);
	/* @Query(value="SELECT...")
	Car myquery(); komentars turpinas un nekad nebeidzas nekad nekad nekad
*/
	
}
