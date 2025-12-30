package com.web.coffee.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.coffee.domain.UserDTO;
import com.web.coffee.service.UserService;

@RestController
@RequestMapping("/api/coffee")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/new/members")
	public ResponseEntity<Integer> newMembers(@RequestBody UserDTO userDto) {
		if ("Y".equals(userService.retrieveMemberYn(userDto.getName()))) {
			return new ResponseEntity<>(-1, HttpStatus.OK);
		}

		userDto.setCreatedAt(getSysDt());
		userDto.setUpdatedAt(getSysDt());

		int resultCd = userService.newMember(userDto);
		return new ResponseEntity<>(resultCd, HttpStatus.OK);
	}
	
	@GetMapping("/members/all")
	public List<UserDTO> activeMembersAll() {
		return userService.listActiveMembersAll();
	}

	@GetMapping("/members/active")
	public List<UserDTO> activeMembers() {
		return userService.listActiveMembers();
	}

	@PostMapping("/members/{memberId}/active")
	public ResponseEntity<Integer> activeUpdate(@PathVariable String memberId) {
		int resultCd = 0;
		
		if("Y".equals(userService.retrieveMemberActiveYn(memberId))) {
			resultCd = userService.updateMemberActiveYn(memberId, "N", getSysDt());
		} else {
			resultCd = userService.updateMemberActiveYn(memberId, "Y", getSysDt());
		}
		 
		return new ResponseEntity<>(resultCd, HttpStatus.OK);
	}

	private String getSysDt() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
