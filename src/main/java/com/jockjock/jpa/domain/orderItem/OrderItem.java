package com.jockjock.jpa.domain.orderItem;

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
public class OrderItem {
	
	@Id @GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	
	private Long order_id;
	
	private Long item_id;
	
	private int order_price;
	
	private int count;

}
