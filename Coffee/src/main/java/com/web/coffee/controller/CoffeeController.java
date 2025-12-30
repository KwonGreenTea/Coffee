package com.web.coffee.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.coffee.domain.CoffeeDTO;
import com.web.coffee.domain.UserDTO;
import com.web.coffee.service.CoffeeService;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

	@Autowired
	private CoffeeService coffeeService;
	
	@PostMapping("/calendar/purchase")
	public ResponseEntity<Integer> activeMembers(@RequestBody UserDTO userDto) {
		int resultCd = 0;
		
		CoffeeDTO coffeeDTO = new CoffeeDTO();
		
		// 기존 데이터 확인
		int memberId = userDto.getMemberId();
		String workDate = userDto.getWorkDate();
		
		coffeeDTO.setMemberId(memberId);
		coffeeDTO.setWorkDate(workDate);
		coffeeDTO.setCreatedAt(getSysDt());
		coffeeDTO.setUpdatedAt(getSysDt());
		
		if ("Y".equals(coffeeService.retrieveDateYn(workDate))) {
			resultCd = coffeeService.updateCoffeeDate(coffeeDTO);
		} else {
			resultCd = coffeeService.insertCoffeeDate(coffeeDTO);
		}

		return new ResponseEntity<>(resultCd, HttpStatus.OK);
	}
	
	@PostMapping("/calendar/delete")
	public ResponseEntity<Integer> deleteCal(@RequestBody CoffeeDTO coffeeDTO) {
		String workDate = coffeeDTO.getWorkDate();
		
		int resultCd = coffeeService.deleteCoffeeDate(workDate);

		return new ResponseEntity<>(resultCd, HttpStatus.OK);
	}
	
	@GetMapping("/calendar/events")
	public List<CoffeeDTO> calendarEvents(@RequestParam String start, @RequestParam String end) {
		return coffeeService.allCoffeeList(start.substring(0, 10), end.substring(0, 10));
	}

	private String getSysDt() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
