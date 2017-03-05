package com.backpack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backpack.model.Project;

/**
 * 
 * @author lemonpro
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
