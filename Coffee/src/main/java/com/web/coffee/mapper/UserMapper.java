package com.web.coffee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.coffee.domain.UserDTO;

@Mapper
public interface UserMapper {

	List<UserDTO> listActiveMembers();

	String retrieveMemberYn(String name);

	int newMember(@Param("userDTO") UserDTO userDto);

	int updateMemberActiveYn(@Param("memberId") String memberId, @Param("active") String active, @Param("sysDt") String sysDt);

	String retrieveMemberActiveYn(String memberId);

	List<UserDTO> listActiveMembersAll();


}
