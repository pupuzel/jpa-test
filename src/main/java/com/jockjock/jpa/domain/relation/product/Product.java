package com.jockjock.jpa.domain.relation.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "T_PRODUCT")
@Getter
@Setter
public class Product {
	
	@Id @GeneratedValue
	@Column(name="PRODUCT_ID")
	private Long id;
	
	private String name;
}
