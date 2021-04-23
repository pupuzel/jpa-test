package com.jockjock.jpa.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jockjock.jpa.domain.relation.board.BoardDAO;
import com.jockjock.jpa.domain.relation.member.Member;
import com.jockjock.jpa.domain.relation.member.MemberDAO;
import com.jockjock.jpa.domain.relation.order.Order;
import com.jockjock.jpa.domain.relation.order.OrderDAO;
import com.jockjock.jpa.domain.relation.post.PostDAO;
import com.jockjock.jpa.domain.relation.product.Product;
import com.jockjock.jpa.domain.relation.product.ProductDAO;

import lombok.AllArgsConstructor;

@Service("testRelationService")
@AllArgsConstructor
public class TestRelationService {

	private PostDAO postDAO;
	
	private BoardDAO boardDAO;
	
	private MemberDAO memberDAO;
	
	private ProductDAO productDAO;
	
	private OrderDAO orderDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	public void save() throws Exception {
		
		Member member1 = new Member();
		member1.setName("유저A");
		memberDAO.save(member1);

		Product productA = new Product();
		productA.setName("상품A");
		productDAO.save(productA);

		Product productB = new Product();
		productB.setName("상품B");
		productDAO.save(productB);
		
		Order order1 = new Order();
		order1.setMember(member1);
		order1.setProduct(productA);
		orderDAO.save(order1);
		
		Order order2 = new Order();
		order2.setMember(member1);
		order2.setProduct(productB);
		orderDAO.save(order2);

		memberDAO.findAll().stream().forEach( o -> {
			System.out.println(o.getName());
			
			o.getOrders().stream().forEach( order -> {
				System.out.println(order.getProduct().getName());
			});
		});

	}
	
	public void read() throws Exception {

	}
	
}