package com.web.coffee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.coffee.domain.CoffeeDTO;

@Mapper
public interface CoffeeMapper {

	String retrieveDateYn(String workDate);

	int updateCoffeeDate(@Param("coffeeDTO") CoffeeDTO coffeeDTO);

	int insertCoffeeDate(@Param("coffeeDTO") CoffeeDTO coffeeDTO);

	List<CoffeeDTO> allCoffeeList(@Param("startDate") String startDate, @Param("endDate") String endDate);

	int deleteCoffeeDate(@Param("workDate") String workDate);
	
}
