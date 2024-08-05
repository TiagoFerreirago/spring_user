package com.example.spring.user.user_spring.mock.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.spring.user.userspring.entities.User;
import com.example.spring.user.userspring.vo.v1.UserVO;

public class MockDozer {

	private LocalDate date = LocalDate.now();
	
	
	public User mockUser(int number) {
		User user = new User();
		
		user.setCpf("12345678910 " + number);
		user.setDt_Nasc(date);
		user.setGenre((number%2==0 ? "Male " : "Female ")+number);
		user.setId(Long.valueOf(number));
		user.setName((number%2==0 ? "Guilhermo "+number:"Catharine "+number));
		return user;
	}
	
	public UserVO mockUserVO(int number) {
		UserVO vo = new UserVO();
		vo.setCpf("12345678910 "+number);
		vo.setDt_Nasc(date);
		vo.setGenre((number % 2 == 0 ? "Male " : "Female ")+number);
		vo.setKey(Long.valueOf(number));
		vo.setName(number%2==0 ? "Guilhermo "+number:"Catharine "+number);
		return vo;
	}
	
	public  List<User> mockListUser(){
		List<User>users = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			users.add(mockUser(i));
		}
		return users;
	}
	
	public  List<UserVO> mockListUserVO(){
		List<UserVO> userVo = new ArrayList<>();
		for(int i = 0; i < 10;i++) {
			userVo.add(mockUserVO(i));
		}
		return userVo;
	}
	
	public User mockUser() {
		return mockUser(0);
	}
	
	public UserVO mockUserVO() {
		return mockUserVO(0);
	}
}
