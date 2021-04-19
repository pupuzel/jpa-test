package com.jockjock.jpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		
		
		result.put("result", "Y");
		return result;
	}
	
	public Map read() throws Exception {
		Map result = new HashMap<String,Object>();
		
		Optional<Post> post = postDAO.findById(2L);
		String board_title = post.get().getBoard().getTitle();
		System.out.println(board_title);
		
		Optional<Board> board = boardDAO.findById(1L);
		List<Post> posts = board.get().getPosts();
		posts.stream().forEach( o -> {
			System.out.println(o.getTitle());
		});
		
		result.put("result", "Y");
		return result;
	}
}
