package com.web.coffee.service;

import java.util.List;

import com.web.coffee.domain.UserDTO;

public interface UserService {

	List<UserDTO> listActiveMembers();

	String retrieveMemberYn(String name);

	int newMember(UserDTO userDto);

	int updateMemberActiveYn(String memberId, String active, String sysDt);

	String retrieveMemberActiveYn(String memberId);

	List<UserDTO> listActiveMembersAll();
	
}
