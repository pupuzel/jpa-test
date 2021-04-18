package com.jockjock.jpa.domain.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.jockjock.jpa.domain.member.Member;
import com.jockjock.jpa.domain.product.Product;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="T_ORDER")
public class Order {
	
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "MEMBER_ID")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name= "PRODUCT_ID")
	private Product product;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public void setMember(Member member) {
		if(this.member != member) {
			this.member = member;
			member.getOrders().add(this);
		}


	}

}
