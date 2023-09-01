package de.starwit.example.testexample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestexampleApplication.class)
class JPATests {

    @Autowired
	private MyUserRepository repository;

	@BeforeEach
	public void addSampleData() {
		for (int i = 1; i<=10; i++) {
			MyUser u = new MyUser();
			u.setName("Test-" + i);
			u.setEmail("test-"+i+"@testmail.de");
			repository.save(u);
		}
	}

	@Test
	public void checkUsersStored() {
		int amountOfUsers = repository.findAll().size();
		assertEquals(10,amountOfUsers);
	}

	@Test
	public void testRest() {

	}

	@Test
	void contextLoads() {
	}

}
