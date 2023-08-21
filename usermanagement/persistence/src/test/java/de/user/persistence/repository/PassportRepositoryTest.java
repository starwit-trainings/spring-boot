package de.user.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.user.persistence.entity.PassportEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for PassportRepository
 */
@DataJpaTest
public class PassportRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PassportRepository repository;

    @Test
    public void testFindAll() {
        List<PassportEntity> passports = repository.findAll();
        assertTrue(passports.isEmpty());
    }
}
