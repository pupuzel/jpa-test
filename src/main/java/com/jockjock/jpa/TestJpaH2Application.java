package com.jockjock.jpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jockjock.jpa.domain.board.Board;
import com.jockjock.jpa.domain.board.BoardDAO;
import com.jockjock.jpa.domain.member.Member;
import com.jockjock.jpa.domain.member.MemberDAO;
import com.jockjock.jpa.domain.order.Order;
import com.jockjock.jpa.domain.order.OrderDAO;
import com.jockjock.jpa.domain.order.OrderStatus;
import com.jockjock.jpa.domain.post.Post;
import com.jockjock.jpa.domain.post.PostDAO;
import com.jockjock.jpa.domain.product.Product;
import com.jockjock.jpa.domain.product.ProductDAO;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TestJpaH2Application {
	
	private PostDAO postDAO;
	
	private BoardDAO boardDAO;
	
	private MemberDAO memberDAO;
	
	private ProductDAO productDAO;
	
	private OrderDAO orderDAO;
	
	
	@Bean
	public ApplicationRunner applicationRun() {
		return (args) -> {
			Board board = new Board();
			board.setTitle("커뮤니티");
			boardDAO.save(board);
			
			/*
			 * 저장하는 순간 영속성 앤티티에서 관리하게됨 그래서 아래 update sql 구문으로 날려줌
			 * */
			//board.setTitle("큐앤에이");
			
			Post post1 = new Post();
			post1.setTitle("테스트 제목1");
			post1.setContent("테스트 컨텐트");
			post1.setUser_id("jockjock");
			post1.setBoard(board);
			postDAO.save(post1);
			
			Post post2 = new Post();
			post2.setTitle("테스트 제목2");
			post2.setContent("테스트 컨텐트");
			post2.setUser_id("thor");
			post2.setBoard(board);
			postDAO.save(post2);
			
			Post post3 = new Post();
			post3.setTitle("테스트 제목3");
			post3.setContent("테스트 컨텐트");
			post3.setUser_id("pupuzel");
			post3.setBoard(board);
			
			//board = boardDAO.findById(1L).get();
			//board.getPosts().add(post3);
			
			/***************************************************************************************************/
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TestJpaH2Application.class, args);
	}

}
