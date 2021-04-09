package com.jockjock.jpa.domain.board;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_BOARD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board implements Serializable{
	
	private static final long serialVersionUID = -5588557132497517392L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOARD_ID")
	private long id;
	
	private String title;
	
    @Builder
    public Board(String title) {
    	this.title=title;
    }
}
