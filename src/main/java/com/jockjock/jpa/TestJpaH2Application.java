package com.jockjock.jpa;

import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jockjock.jpa.domain.board.Board;
import com.jockjock.jpa.domain.board.BoardDAO;
import com.jockjock.jpa.domain.post.Post;
import com.jockjock.jpa.domain.post.PostDAO;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TestJpaH2Application {
	
	private PostDAO postDAO;
	
	private BoardDAO boardDAO;
	
	@Bean
	public ApplicationRunner applicationRun() {
		return (args) -> {
			
			Board board = new Board();
			board.setTitle("커뮤니티");
			boardDAO.save(board);
			
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
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TestJpaH2Application.class, args);
	}

}
