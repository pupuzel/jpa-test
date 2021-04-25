package com.jockjock.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jockjock.jpa.domain.join.item.Item;
import com.jockjock.jpa.domain.join.movie.Movie;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Item item = new Item();
		item.setName("아이템1");
		item.setPrice(5000);
		
		em.persist(item);
		
		Movie movie = new Movie();
		movie.setActor("천우희");
		movie.setName("본드녀");
		
		em.persist(movie);
	}
	

}
