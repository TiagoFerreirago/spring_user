package com.example.spring.user.userspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.spring.user.userspring.controller.UserController;
import com.example.spring.user.userspring.dozermapper.DozerMapper;
import com.example.spring.user.userspring.entities.User;
import com.example.spring.user.userspring.exception.handler.HandlerNotFoundException;
import com.example.spring.user.userspring.repository.UserRepository;
import com.example.spring.user.userspring.vo.v1.UserVO;

import jakarta.transaction.Transactional;
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserVO findById(Long id) {
		User user = repository.findById(id).orElseThrow( () -> new HandlerNotFoundException("User Not Found"));
		UserVO vo = DozerMapper.parseEntityForVO(user, UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
		return vo;
	}
	@Transactional
	public List<UserVO> findAll(){
		List<User> listUser = repository.findAll();
		List<UserVO> vo = DozerMapper.parseListEntityForVO(listUser, UserVO.class);
		vo.stream().forEach(p -> p.add(linkTo(methodOn(UserController.class).findById(p.getKey())).withSelfRel()));
		return vo;
	}
	@Transactional
	public UserVO create(UserVO user) {
		User entity = DozerMapper.parseEntityForVO(user, User.class);
		UserVO vo = DozerMapper.parseEntityForVO(repository.save(entity), UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(user.getKey())).withSelfRel());
		return vo;
	}
	@Transactional
	public UserVO update(UserVO user) {
		User entity = repository.findById(user.getKey()).orElseThrow( () -> new HandlerNotFoundException("User Not Found"));
		entity.setCpf(user.getCpf());
		entity.setDt_Nasc(user.getDt_Nasc());
		entity.setGenre(user.getGenre());
		entity.setName(user.getName());
		UserVO vo = DozerMapper.parseEntityForVO(entity, UserVO.class);
		vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	@Transactional
	public void delete(Long id){
		User user = repository.findById(id).orElseThrow( () -> new HandlerNotFoundException("User Not Found"));
		repository.delete(user);
	}
}
