package com.jockjock.jpa.domain.item;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
	
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	
	private int price;
	
	private int stock_quantity;
	

}
