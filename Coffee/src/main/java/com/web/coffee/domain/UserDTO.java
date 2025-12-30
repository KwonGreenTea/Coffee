package com.web.coffee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter 
@Setter
@ToString 
public class UserDTO {

	private int memberId;
    private String name;
    private String jobTitle;
    private String activeYn;   
    private String createdAt;  
    private String updatedAt;
    
    private String workDate;
	
} 
