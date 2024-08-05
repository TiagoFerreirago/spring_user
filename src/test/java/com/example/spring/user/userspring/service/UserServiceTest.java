package com.example.spring.user.userspring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.spring.user.user_spring.mock.test.MockDozer;
import com.example.spring.user.userspring.entities.User;
import com.example.spring.user.userspring.exception.handler.HandlerNotFoundUserNullException;
import com.example.spring.user.userspring.repository.UserRepository;
import com.example.spring.user.userspring.vo.v1.UserVO;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	private LocalDate date = LocalDate.now();
	MockDozer input;
	
	@Mock
	private UserRepository repository;
	
	@InjectMocks
	private UserService service;
	@BeforeEach
	void setUp() throws Exception {
		input = new MockDozer();
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void findByIdTest() {
		User user = input.mockUser(1);
		user.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</user/v1/1>;rel=\"self\"]"));
		assertEquals("12345678910 1",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Female 1",result.getGenre());
		assertEquals("Catharine 1",result.getName());
	}
	
	@Test
	void createTest() {
		User user = input.mockUser(1);
		user.setId(1L);
		
		User persistence = user;
		persistence.setId(1L);
		
		UserVO vo =input.mockUserVO(1);
		vo.setKey(1L);
		
		when(repository.save(user)).thenReturn(persistence);
		
		var result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</user/v1/1>;rel=\"self\"]"));
		assertEquals("12345678910 1",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Female 1",result.getGenre());
		assertEquals("Catharine 1",result.getName());
	}
	
	@Test
	void createExceptionTest() {
		Exception exception = assertThrows(HandlerNotFoundUserNullException.class, () -> 
		{service.create(null);});
		
		String expectedMessage = "the persisted object cannot be null";
		String actualMessage = exception.getMessage();
		
		assertTrue(expectedMessage.contains(actualMessage));
	}
	
	@Test
	void updateTest() {
		User user = input.mockUser(1);
			
		User persistence = user;
		persistence.setId(1L);
		
		UserVO vo = input.mockUserVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		when(repository.save(user)).thenReturn(persistence);
		
		var result = service.update(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</user/v1/1>;rel=\"self\"]"));
		assertEquals("12345678910 1",result.getCpf());
		assertEquals(date,result.getDt_Nasc());
		assertEquals("Female 1",result.getGenre());
		assertEquals("Catharine 1",result.getName());
		
	}
	
	@Test
	void updateExceptionTest() {
		Exception exception = assertThrows(HandlerNotFoundUserNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "the persisted object cannot be null";
		String actualMessage = exception.getMessage();
		
		assertTrue(expectedMessage.contains(actualMessage));
	}
	@Test
	void deleteTest() {
		User user = input.mockUser(1);
		user.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		service.delete(1L);
	}
	
	@Test
	void findAllTest(){
		
		List<User> users = input.mockListUser();
		
		when(repository.findAll()).thenReturn(users);
		
		var result = service.findAll();
		
		assertNotNull(result);
		assertEquals(10, result.size());
		
		UserVO voOne = result.get(1);
		
		assertNotNull(voOne);
		assertNotNull(voOne.getKey());
		assertNotNull(voOne.getLinks());
		assertTrue(voOne.toString().contains("links: [</user/v1/1>;rel=\"self\"]"));
		assertEquals("12345678910 1",voOne.getCpf());
		assertEquals(date,voOne.getDt_Nasc());
		assertEquals("Female 1",voOne.getGenre());
		assertEquals("Catharine 1",voOne.getName());
		
		var voFour = result.get(4);
		
		assertNotNull(voFour);
		assertNotNull(voFour.getKey());
		assertNotNull(voFour.getLinks());
		assertTrue(voFour.toString().contains("links: [</user/v1/4>;rel=\"self\"]"));
		assertEquals("12345678910 4",voFour.getCpf());
		assertEquals(date,voFour.getDt_Nasc());
		assertEquals("Male 4",voFour.getGenre());
		assertEquals("Guilhermo 4",voFour.getName());
		
		var voNine = result.get(9);
		
		assertNotNull(voNine);
		assertNotNull(voNine.getKey());
		assertNotNull(voNine.getLinks());
		assertTrue(voNine.toString().contains("links: [</user/v1/9>;rel=\"self\"]"));
		assertEquals("12345678910 9",voNine.getCpf());
		assertEquals(date,voNine.getDt_Nasc());
		assertEquals("Female 9",voNine.getGenre());
		assertEquals("Catharine 9",voNine.getName());
	}
	
	

}
