package com.backpack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backpack.model.Issue;

/**
 * 
 * @author lemonpro
 *
 */
public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
