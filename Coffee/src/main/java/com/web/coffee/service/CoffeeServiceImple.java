package com.web.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.coffee.domain.CoffeeDTO;
import com.web.coffee.mapper.CoffeeMapper;

@Service
public class CoffeeServiceImple implements CoffeeService {
	
	@Autowired
	private CoffeeMapper coffeeMapper;

	@Override
	public String retrieveDateYn(String workDate) {
		return coffeeMapper.retrieveDateYn(workDate);
	}

	@Transactional
	@Override
	public int updateCoffeeDate(CoffeeDTO coffeeDTO) {
		coffeeMapper.deleteCoffeeDate(coffeeDTO.getWorkDate());
		return coffeeMapper.insertCoffeeDate(coffeeDTO);
	}

	@Override
	public int insertCoffeeDate(CoffeeDTO coffeeDTO) {
		return coffeeMapper.insertCoffeeDate(coffeeDTO);
	}

	@Override
	public List<CoffeeDTO> allCoffeeList(String startDate, String endDate) {
		return coffeeMapper.allCoffeeList(startDate, endDate);
	}

	@Override
	public int deleteCoffeeDate(String workDate) {
		return coffeeMapper.deleteCoffeeDate(workDate);
	}
	
}
