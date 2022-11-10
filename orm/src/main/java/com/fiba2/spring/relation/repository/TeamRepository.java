package com.fiba2.spring.relation.repository;

import org.springframework.data.repository.CrudRepository;
import com.fiba2.spring.relation.entity.Team;

public interface TeamRepository extends CrudRepository <Team, Long> {
}
