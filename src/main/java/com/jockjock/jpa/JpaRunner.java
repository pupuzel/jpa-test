package com.jockjock.jpa;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jockjock.jpa.domain.join.item.Item;
import com.jockjock.jpa.domain.join.movie.Movie;
import com.jockjock.jpa.domain.relation.board.Board;
import com.jockjock.jpa.domain.relation.member.Member;
import com.jockjock.jpa.domain.relation.order.Order;
import com.jockjock.jpa.domain.relation.order.QOrder;
import com.jockjock.jpa.domain.relation.post.Post;
import com.jockjock.jpa.domain.relation.product.Product;
import com.jockjock.jpa.domain.test.academy.Academy;
import com.jockjock.jpa.domain.test.academy.AcademyQueryRepository;
import com.jockjock.jpa.domain.test.academy.AcademyRepository;
import com.jockjock.jpa.embedded.Address;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	private AcademyRepository  academyRepository;
	
	private AcademyQueryRepository academyQueryRepository;
	
	private EntityManager em;
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		nativeQueryTest2();
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
	
	private void orderTestData() {
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
	
	private Board boardTestData() {
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
		
		return board;
	}
	
	
	private void casCadeTest() {
		Board board = boardTestData();
		
		board = em.find(Board.class, board.getId());
		board.getPosts().remove(0);
	}
	
	private void EmbeddTest() {
		Member member = new Member();
		member.setName("전진광");
		
		Address address = new Address();
		address.setCity("부천");
		address.setStreet("오정구 원종동");
		
		member.setHomeAddress(address);

		em.persist(member);
		em.flush();
		
		String jpql = "select m from Member as m where m.name = :name ";
		var list = em.createQuery(jpql, Member.class)
						.setParameter("name", "전진광")
						.getResultList();
		
		list.stream().forEach(System.out::println);
		
	}
	
	private void fetchJoinTest() {
		orderTestData();
		
		em.flush();
/*		
		String jpql1 = "select o, m.name from Order o inner join o.member m";
		List<Object[]> list = em.createQuery(jpql1)
						.setFirstResult(0)
						.setMaxResults(10)
						.getResultList();
		
		for(Object[] row : list) {
			Stream.of(row)
				.forEach(o -> {
					System.out.println(o.toString());
				});
		}
*/		
		//패치조인 하면 지연로딩이 아닌 쿼리 하나로 전체 조회 할 수 있음
		String jpql2 = "select o from Order o inner join fetch o.member ";
		var orderList = em.createQuery(jpql2, Order.class).getResultList();
		orderList.stream().forEach( o -> {
			var name = o.getMember().getName();
			System.out.println(name);
		});
	}
	
	private void criteriaTest() {
		Member member = new Member();
		member.setName("전진광");
		
		Address address = new Address();
		address.setCity("부천");
		address.setStreet("오정구 원종동");
		
		member.setHomeAddress(address);

		em.persist(member);
		em.flush();
		
		CriteriaBuilder cb =  em.getCriteriaBuilder();
		CriteriaQuery<Member> query =  cb.createQuery(Member.class);
		
		Root<Member> m =  query.from(Member.class);
		
		CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "전진광"));
		
		var list = em.createQuery(cq).getResultList();
		
		list.stream().forEach(System.out::println);
	}
	
	
	private void queryDslTest() {
		orderTestData();

		JPAQueryFactory  query = new JPAQueryFactory(em); 
		QOrder qOrder = new QOrder("o");
		List<Order> orders = (List<Order>)
				query.from(qOrder)
				.where(qOrder.member.name.eq("유저A"))
				.orderBy(qOrder.member.name.desc())
				.fetch();
		
		orders.stream().forEach( o -> System.out.println(o.getMember().getName()) );

	}
	
	private void queryDslTest2() {
		
        String name = "jojoldu";
        String address = "jojoldu@gmail.com";
        Academy academy = new Academy(name, address);
        //academy.setDate(LocalDateTime.now());
        
        academyRepository.save(academy);
        
        List<Academy> result = academyQueryRepository.findByName(name);
        
        System.out.println(result.size());
	}
	
	private void nativeQueryTest1() {
		boardTestData();
		
		String sql = "SELECT * FROM T_POST";
		Query nativeQuery = em.createNativeQuery(sql);
		
		List<Post> list = nativeQuery.getResultList();
		list.stream().forEach( o -> {
			System.out.println(o.toString());
		});
	}
	
	private void nativeQueryTest2() {
		orderTestData();
		
		String sql = " SELECT " + 
						"    A.*" + 
						"   ,(SELECT COUNT(1) FROM T_ORDER WHERE MEMBER_ID = A.MEMBER_ID) AS ORDER_COUNT" + 
						" FROM T_MEMBER A";
		
		Query q = em.createNativeQuery(sql,"memberList");
		List<Object[]> list = q.getResultList();
		
		for(Object[] row : list) {
			Member m = (Member) row[0];
			BigInteger count = (BigInteger) row[1];
			
			System.out.println(m.getName());
			System.out.println(count);
		}
	}

}
