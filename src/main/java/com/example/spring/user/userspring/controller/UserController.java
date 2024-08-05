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
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.user.userspring.util.MediaType;
import com.example.spring.user.userspring.service.UserService;
import com.example.spring.user.userspring.vo.v1.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema; 

@RestController
@RequestMapping(value = "/api/user/v1")
@Tag(name = "Users")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "FindById a user", description = "FindById a user",
	tags = {"Users"},
	responses = {@ApiResponse(description = "Success", responseCode = "200", 
	content = {
			@Content(
					schema = @Schema(implementation = UserVO.class))
					}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content =@Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content)
			})
	
	public UserVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	

	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "FindAll users", description = "FindAll users",tags = {"Users"}, responses = {
			@ApiResponse(description = "Success", responseCode ="200",
					content = { @Content(mediaType = "application/json",
					array = @ArraySchema(schema = @Schema(implementation = UserVO.class)))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content)
	})
	public List<UserVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "creating user in xml, json and yml ",description = "creating user in xml, json and yml",
	tags = {"Users"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(
			schema = @Schema(implementation = UserVO.class))),
	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
	@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
	public UserVO create(@RequestBody UserVO user) {
		return service.create(user);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "updating user in xml, json and yml", description = "updating user in xml, json and yml", tags = {"Users"},
	responses = {@ApiResponse(description = "Updated", responseCode = "200", content = @Content(
			schema = @Schema(implementation = UserVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error",responseCode = "500", content = @ Content)})
	public UserVO update(@RequestBody UserVO user) {
		return service.update(user);
	}
	@Operation(summary = "Delete a User", description = "Delete a User", tags = {"Users"}, responses = {
			@ApiResponse(description = "No Content", responseCode = "204",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserVO> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
