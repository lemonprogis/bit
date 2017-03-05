package com.backpack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backpack.model.People;

/**
 * 
 * @author lemonpro
 *
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
