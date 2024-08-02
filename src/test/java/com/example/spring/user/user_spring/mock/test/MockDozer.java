package com.example.spring.user.user_spring.mock.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.spring.user.userspring.entities.User;
import com.example.spring.user.userspring.vo.v1.UserVO;

public class MockDozer {

	private String hr = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private LocalDate date = LocalDate.parse(hr);
	
	private User mockUser(int number) {
		User user = new User();
		
		user.setCpf("12345678910 " + number);
		user.setDt_Nasc(date);
		user.setGenre((number%2==0 ? "Male " : "Female ")+number);
		user.setId(Long.valueOf(number));
		user.setName("Guilhermo "+number);
		return user;
	}
	
	private UserVO mockUserVO(int number) {
		UserVO vo = new UserVO();
		vo.setCpf("12345678910 "+number);
		vo.setDt_Nasc(date);
		vo.setGenre((number % 2 == 0 ? "Male " : "Female ")+number);
		vo.setId(Long.valueOf(number));
		vo.setName("Guilhermo "+number);
		return vo;
	}
	
	private List<User> mockListUser(){
		List<User>users = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			users.add(mockUser(i));
		}
		return users;
	}
	
	private List<UserVO> mockListUserVO(){
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
