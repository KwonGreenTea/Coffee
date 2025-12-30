package com.web.coffee.service;

import java.util.List;

import com.web.coffee.domain.CoffeeDTO;

public interface CoffeeService {

	String retrieveDateYn(String workDate);

	int updateCoffeeDate(CoffeeDTO coffeeDTO);

	int insertCoffeeDate(CoffeeDTO coffeeDTO);

	List<CoffeeDTO> allCoffeeList(String startDate, String endDate);

	int deleteCoffeeDate(String workDate);
	
}
