package com.example.spring.user.user_spring.mock.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.spring.user.userspring.dozermapper.DozerMapper;
import com.example.spring.user.userspring.entities.User;
import com.example.spring.user.userspring.vo.v1.UserVO;

public class TestDozerMapper {

	private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private LocalDate convertDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private MockDozer mock;
	
	@BeforeEach
	public void upTestDozer() {
		mock = new MockDozer();
	}
	
	@Test
	void testParseUserForVo() {
		UserVO vo = DozerMapper.parseEntityForVO(mock.mockUser(), UserVO.class);
		vo.setId(1L);
		assertEquals("12345678910 0",vo.getCpf());
		assertEquals(convertDate,vo.getDt_Nasc());
		assertEquals("Male 0",vo.getGenre());
		assertEquals(1L, vo.getId());
		assertEquals("Guilhermo 0",vo.getName());
	}
	@Test
	void testParseVoForUser() {
		User user = DozerMapper.parseEntityForVO(mock.mockUserVO(1), User.class);
		user.setId(1L);
		
		assertEquals("12345678910 1",user.getCpf());
		assertEquals(convertDate,user.getDt_Nasc());
		assertEquals("Female 1",user.getGenre());
		assertEquals(1L,user.getId());
		assertEquals("Guilhermo 1",user.getName());
	}
	@Test
	void testParseListVOForUser() {
		List<User> users = DozerMapper.parseListEntityForVO(mock.mockListUserVO(), User.class);
		
		User userOne = users.get(1);
		
		assertEquals("12345678910 1",userOne.getCpf());
		assertEquals(convertDate,userOne.getDt_Nasc());
		assertEquals("Female 1",userOne.getGenre());
		assertEquals(1L, userOne.getId());
		assertEquals("Guilhermo 1", userOne.getName());
		
		
		User userFour = users.get(4);
		
		assertEquals("12345678910 4",userFour.getCpf());
		assertEquals(convertDate,userFour.getDt_Nasc());
		assertEquals("Male 4",userFour.getGenre());
		assertEquals(4L, userFour.getId());
		assertEquals("Guilhermo 4", userFour.getName());
		
		User userSeven = users.get(7);
		
		assertEquals("12345678910 7",userSeven.getCpf());
		assertEquals(convertDate,userSeven.getDt_Nasc());
		assertEquals("Female 7",userSeven.getGenre());
		assertEquals(7L, userSeven.getId());
		assertEquals("Guilhermo 7", userSeven.getName());
	}
	@Test
	void testParseListUserForVO() {
		List<UserVO> usersVo = DozerMapper.parseListEntityForVO(mock.mockListUser(), UserVO.class);
		
		UserVO voTwo = usersVo.get(2);
		
		assertEquals("12345678910 2",voTwo.getCpf());
		assertEquals(convertDate,voTwo.getDt_Nasc());
		assertEquals("Male 2",voTwo.getGenre());
		assertEquals(2L,voTwo.getId());
		assertEquals("Guilhermo 2",voTwo.getName());
		
		UserVO voFive = usersVo.get(5);
		
		assertEquals("12345678910 5",voFive.getCpf());
		assertEquals(convertDate,voFive.getDt_Nasc());
		assertEquals("Female 5",voFive.getGenre());
		assertEquals(5L,voFive.getId());
		assertEquals("Guilhermo 5",voFive.getName());
		
		UserVO voEight = usersVo.get(8);
		
		assertEquals("12345678910 8",voEight.getCpf());
		assertEquals(convertDate,voEight.getDt_Nasc());
		assertEquals("Male 8",voEight.getGenre());
		assertEquals(8L,voEight.getId());
		assertEquals("Guilhermo 8",voEight.getName());
	}
	
}
