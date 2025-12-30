package com.web.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.coffee.domain.UserDTO;
import com.web.coffee.mapper.UserMapper;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDTO> listActiveMembers() {
		return userMapper.listActiveMembers();
	}

	@Override
	public String retrieveMemberYn(String name) {
		return userMapper.retrieveMemberYn(name);
	}

	@Override
	public int newMember(UserDTO userDto) {
		return userMapper.newMember(userDto);
	}

	@Override
	public int updateMemberActiveYn(String memberId, String active, String sysDt) {
		return userMapper.updateMemberActiveYn(memberId, active, sysDt);
	}

	@Override
	public String retrieveMemberActiveYn(String memberId) {
		return userMapper.retrieveMemberActiveYn(memberId);
	}

	@Override
	public List<UserDTO> listActiveMembersAll() {
		return userMapper.listActiveMembersAll();
	}
	

	
}
