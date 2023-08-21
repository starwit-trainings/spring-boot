package de.user.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.user.persistence.entity.MyUserEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for MyUserRepository
 */
@DataJpaTest
public class MyUserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MyUserRepository repository;

    @Test
    public void testFindAll() {
        List<MyUserEntity> myusers = repository.findAll();
        assertTrue(myusers.isEmpty());
    }
}
