package com.jockjock.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jockjock.jpa.domain.relation.board.Board;
import com.jockjock.jpa.domain.relation.board.BoardDAO;
import com.jockjock.jpa.domain.relation.member.MemberDAO;
import com.jockjock.jpa.domain.relation.order.OrderDAO;
import com.jockjock.jpa.domain.relation.post.PostDAO;
import com.jockjock.jpa.domain.relation.product.ProductDAO;

import lombok.AllArgsConstructor;

@Service("testRelationService")
@AllArgsConstructor
public class TestService {

	private PostDAO postDAO;
	
	private BoardDAO boardDAO;
	
	private MemberDAO memberDAO;
	
	private ProductDAO productDAO;
	
	private OrderDAO orderDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	public void save() throws Exception {
		

	}
	
	public void read() throws Exception {

	}
	
}