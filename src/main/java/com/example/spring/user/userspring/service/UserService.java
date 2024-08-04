package com.example.spring.user.userspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return DozerMapper.parseEntityForVO(user, UserVO.class);
	}
	@Transactional
	public List<UserVO> findAll(){
		List<User> listUser = repository.findAll();
		return DozerMapper.parseListEntityForVO(listUser, UserVO.class);
	}
	@Transactional
	public UserVO create(UserVO user) {
		User entity = DozerMapper.parseEntityForVO(user, User.class);
		return DozerMapper.parseEntityForVO(repository.save(entity), UserVO.class);
	}
	@Transactional
	public UserVO update(UserVO user) {
		User entity = repository.findById(user.getId()).orElseThrow( () -> new HandlerNotFoundException("User Not Found"));
		entity.setCpf(user.getCpf());
		entity.setDt_Nasc(user.getDt_Nasc());
		entity.setGenre(user.getGenre());
		entity.setName(user.getName());
		return DozerMapper.parseEntityForVO(entity, UserVO.class);
	}
	@Transactional
	public void delete(Long id){
		User user = repository.findById(id).orElseThrow( () -> new HandlerNotFoundException("User Not Found"));
		repository.delete(user);
	}
}
