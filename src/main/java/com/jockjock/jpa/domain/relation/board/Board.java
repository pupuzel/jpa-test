package com.jockjock.jpa.domain.relation.board;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jockjock.jpa.domain.relation.post.Post;

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
	
	@OneToMany(mappedBy = "board") // 연관관계의 주인인 Post.board 를 지정
	private List<Post> posts = new ArrayList();
}
