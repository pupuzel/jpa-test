package com.jockjock.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jockjock.jpa.domain.join.item.Item;
import com.jockjock.jpa.domain.join.movie.Movie;
import com.jockjock.jpa.domain.relation.board.Board;
import com.jockjock.jpa.domain.relation.member.Member;
import com.jockjock.jpa.domain.relation.order.Order;
import com.jockjock.jpa.domain.relation.post.Post;
import com.jockjock.jpa.domain.relation.product.Product;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		casCadeTest();
	}
	
	
	private void joinTest() {
		Item item = new Item();
		item.setName("아이템1");
		item.setPrice(5000);
		
		em.persist(item);
		
		Movie movie = new Movie();
		movie.setActor("천우희");
		movie.setName("본드녀");
		
		em.persist(movie);
	}
	
	private void persistTest() {
		Member member1 = new Member();
		member1.setName("유저A");
		em.persist(member1);

		Product productA = new Product();
		productA.setName("상품A");
		em.persist(productA);

		Product productB = new Product();
		productB.setName("상품B");
		em.persist(productB);
		
		Order order1 = new Order();
		order1.setMember(member1);
		order1.setProduct(productA);
		em.persist(order1);
		
		Order order2 = new Order();
		order2.setMember(member1);
		order2.setProduct(productB);
		em.persist(order2);

	}
	
	
	private void casCadeTest() {
		Board board = new Board();
		board.setTitle("커뮤니티");
		
		Post post1 = new Post();
		post1.setTitle("테스트1");
		post1.setUser_id("족족몬");
		post1.setBoard(board);
		
		Post post2 = new Post();
		post2.setTitle("테스트2");
		post2.setUser_id("족족몬");
		post2.setBoard(board);
		
		em.persist(board);
		
		em.flush();
		
		board = em.find(Board.class, board.getId());
		board.getPosts().remove(0);
	}
	

}
