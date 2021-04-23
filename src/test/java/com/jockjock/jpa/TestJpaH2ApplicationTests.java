package com.jockjock.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


	/*	
		em.find();    // 엔티티 조회
		em.persist(); // 엔티티 저장
		em.remove();  // 엔티티 삭제
		em.flush();   // 영속성 컨텍스트 내용을 데이터베이스에 반영
		em.detach();  // 엔티티를 준영속 상태로 전환
		em.merge();   // 준영속 상태의 엔티티를 영속상태로 변경
		em.clear();   // 영속성 컨텍스트 초기화
		em.close();   // 영속성 컨텍스트 종료
	*/
@DataJpaTest
class TestJpaH2ApplicationTests {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	void contextLoads() {


		

	}

}
