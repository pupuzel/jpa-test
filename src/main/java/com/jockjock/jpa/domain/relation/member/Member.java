package com.jockjock.jpa.domain.relation.member;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.Persistent;

import com.jockjock.jpa.domain.relation.order.Order;
import com.jockjock.jpa.embedded.Address;
import com.jockjock.jpa.embedded.Period;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SqlResultSetMapping(name ="memberList",
	entities = { @EntityResult(entityClass = Member.class)},
	columns = { @ColumnResult( name="order_count")}
	
)
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
	
	@Transient
	private BigInteger order_count;

	@OneToMany(mappedBy = "member", orphanRemoval = true)
	private List<Order> orders = new ArrayList();
	
}