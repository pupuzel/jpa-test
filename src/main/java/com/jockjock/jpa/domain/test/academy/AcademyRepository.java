package com.jockjock.jpa.domain.test.academy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom{

}
