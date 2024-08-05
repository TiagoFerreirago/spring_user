package com.example.spring.user.userspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.user.userspring.util.MediaType;
import com.example.spring.user.userspring.service.UserService;
import com.example.spring.user.userspring.vo.v1.UserVO;

@RestController
@RequestMapping(value = "/api/user/v1")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public UserVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public List<UserVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public UserVO create(@RequestBody UserVO user) {
		return service.create(user);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public UserVO update(@RequestBody UserVO user) {
		return service.update(user);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserVO> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
