package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//the name of the attributes and name parameter in html should be same
@Entity
@ApiModel(description="Details about user")
public class User {
@Id
@GeneratedValue   //for auto increementing values
@ApiModelProperty("Id must be unique")
private int uid;
@ApiModelProperty("Enter Username")
	private String uname;
	private String pwd;
	private String email;
	private String city;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	
	
	
}
