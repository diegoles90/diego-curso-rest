package com.in28minutes.rest.webservices.restful.webservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findByUsername(String username);

}
