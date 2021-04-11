package com.jockjock.jpa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jockjock.jpa.domain.board.Board;
import com.jockjock.jpa.domain.board.BoardDAO;
import com.jockjock.jpa.domain.post.Post;
import com.jockjock.jpa.domain.post.PostDAO;

import lombok.AllArgsConstructor;

@Service("testService")
@AllArgsConstructor
public class TestService {

	private PostDAO postDAO;
	
	private BoardDAO boardDAO;
	
	public Map save() throws Exception {
		Map result = new HashMap<String,Object>();
		
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
		
		
		result.put("result", "Y");
		return result;
	}
}
