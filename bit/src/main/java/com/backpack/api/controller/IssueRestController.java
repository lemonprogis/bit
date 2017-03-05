package com.backpack.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backpack.model.Issue;
import com.backpack.repository.IssueRepository;

/**
 * 
 * @author lemonpro
 *
 */
@RestController
@RequestMapping(value="/api")
public class IssueRestController {

	@Resource
	private IssueRepository issueRepository;
	
	@RequestMapping( value="/issue",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Issue> findAll() {
		return issueRepository.findAll();
	}

	@RequestMapping( value="/issue/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Issue findOne(@PathVariable("id") Integer id) {
		return issueRepository.findOne(id);
	}
	
	@RequestMapping( value="/issue",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Issue create(@RequestBody Issue issue) {
		return issueRepository.save(issue);
	}

	@RequestMapping( value="/issue/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Issue update(@RequestBody Issue issue) {
		return issueRepository.save(issue);
	}

	@RequestMapping( value="/issue/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Integer id) {
		issueRepository.delete(id);
	}
	
}
