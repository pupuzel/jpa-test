package com.jockjock.jpa.domain.relation.post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.jockjock.jpa.domain.relation.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_POST")
@Getter
@Setter
public class Post {
	@Id @GeneratedValue
	@Column(name = "POST_ID")
	private Long id;
	
	@Column(columnDefinition = "varchar(30)", nullable = false)
	private String user_id;
	
	@Column(columnDefinition = "varchar(40)", nullable = false)
	private String title;
	
	@Column(columnDefinition = "varchar(1000)", nullable = true)
	private String content;
	
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    @UpdateTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;
    	
    @ManyToOne
    @JoinColumn(name ="BOARD_ID")
    private Board board;
    
    public void setBoard(Board board) {
    	this.board = board;
    	board.getPosts().add(this);
    }
}
