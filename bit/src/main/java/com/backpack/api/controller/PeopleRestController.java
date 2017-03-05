package com.backpack.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backpack.model.People;
import com.backpack.repository.PeopleRepository;

/**
 * Spring MVC controller for 'People' management.
 */
@RestController
@RequestMapping(value="/api")
public class PeopleRestController {

	@Resource
	private PeopleRepository peopleRepository;
	
	
	@RequestMapping( value="/people",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<People> findAll() {
		return peopleRepository.findAll();
	}

	@RequestMapping( value="/people/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public People findOne(@PathVariable("id") Integer id) {
		return peopleRepository.findOne(id);
	}
	
	@RequestMapping( value="/people",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public People create(@RequestBody People people) {
		return peopleRepository.save(people);
	}

	@RequestMapping( value="/people/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public People update(@RequestBody People people) {
		return peopleRepository.save(people);
	}

	@RequestMapping( value="/people/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Integer id) {
		peopleRepository.delete(id);
	}
	
}
