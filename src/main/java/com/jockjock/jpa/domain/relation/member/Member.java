package com.jockjock.jpa.domain.relation.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jockjock.jpa.domain.relation.order.Order;
import com.jockjock.jpa.embedded.Address;
import com.jockjock.jpa.embedded.Period;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_MEMBER")
@Data
public class Member {
	
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name; 
	
	@Embedded
	private Period workPeriod;
	
	@Embedded
	private Address homeAddress;

	@OneToMany(mappedBy = "member", orphanRemoval = true)
	private List<Order> orders = new ArrayList();
	
}