package com.jockjock.jpa.domain.test.academy;

import java.util.List;

public interface AcademyRepositoryCustom {
	List<Academy> findByName(String name);
}
