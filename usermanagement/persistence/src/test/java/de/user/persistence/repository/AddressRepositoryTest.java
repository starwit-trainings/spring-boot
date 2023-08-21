package de.user.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.user.persistence.entity.AddressEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for AddressRepository
 */
@DataJpaTest
public class AddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository repository;

    @Test
    public void testFindAll() {
        List<AddressEntity> addresss = repository.findAll();
        assertTrue(addresss.isEmpty());
    }
}
