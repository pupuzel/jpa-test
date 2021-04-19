package com.jockjock.jpa.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Table(name= "T_MEMBER")
@Setter
public class Member {
	
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name;
}
