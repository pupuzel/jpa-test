package com.jockjock.jpa.domain.test.academy;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.jockjock.jpa.domain.test.academy.QAcademy.academy;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Repository 
public class AcademyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }
}
