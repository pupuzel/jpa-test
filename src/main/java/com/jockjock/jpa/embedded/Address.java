package com.jockjock.jpa.embedded;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

	@Column(name = "city") //매핑할 컬럼 지정 가능
	private String city;
	private String street;
	private String zipcode;
	
}
