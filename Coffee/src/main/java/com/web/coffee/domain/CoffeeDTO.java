package com.web.coffee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter 
@Setter
@ToString 
public class CoffeeDTO {

	private String workDate;   
    private int memberId;
    private String createdAt;  
    private String updatedAt; 
    
    private String name;
    private String jobTitle;
    
} 
