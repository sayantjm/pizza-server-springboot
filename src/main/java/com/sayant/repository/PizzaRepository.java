package com.sayant.repository;

import com.sayant.model.Pizza;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	Collection<Pizza> findByName(String name);
}