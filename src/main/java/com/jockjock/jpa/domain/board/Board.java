package com.jockjock.jpa.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_BOARD")
@Getter
@Setter
public class Board {
	
	@Id @GeneratedValue
	@Column(name="BOARD_ID")
	private long id;
	
	private String title;
	
}
