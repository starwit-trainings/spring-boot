package de.user.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.user.persistence.entity.OrganisationEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for OrganisationRepository
 */
@DataJpaTest
public class OrganisationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrganisationRepository repository;

    @Test
    public void testFindAll() {
        List<OrganisationEntity> organisations = repository.findAll();
        assertTrue(organisations.isEmpty());
    }
}
