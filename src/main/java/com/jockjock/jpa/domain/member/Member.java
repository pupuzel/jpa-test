package com.jockjock.jpa.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jockjock.jpa.domain.order.Order;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_MEMBER")
@Getter
@Setter
public class Member {
	
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name; 

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList();
	
}