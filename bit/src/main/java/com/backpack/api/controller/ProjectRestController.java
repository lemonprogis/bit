package com.backpack.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backpack.model.Project;
import com.backpack.repository.ProjectRepository;

/**
 * Spring MVC controller for 'Project' management.
 */
@RestController
@RequestMapping(value="/api")
public class ProjectRestController {

	@Resource
	private ProjectRepository projectRepository;
	
	@RequestMapping( value="/project",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@RequestMapping( value="/project/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Project findOne(@PathVariable("id") Integer id) {
		return projectRepository.findOne(id);
	}
	
	@RequestMapping( value="/project",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Project create(@RequestBody Project project) {
		return projectRepository.save(project);
	}

	@RequestMapping( value="/project/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Project update(@PathVariable("id") Integer id, @RequestBody Project project) {
		return projectRepository.save(project);
	}

	@RequestMapping( value="/project/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Integer id) {
		projectRepository.delete(id);
	}
	
}
