package de.user.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.user.persistence.entity.OrganisationEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for OrganisationRepository
 * Annotation for a JPA test that focuses only on JPA components.
 * Using this annotation will disable full auto-configuration and
 * instead apply only configuration relevant to JPA tests.
 * 
 * By default, tests annotated with @DataJpaTest are transactional and roll back
 * at the end of each test.
 * They also use an embedded in-memory database
 * (replacing any explicit or usually auto-configured DataSource).
 * The @AutoConfigureTestDatabase annotation can be used to override these
 * settings.
 * 
 * SQL queries are logged by default by setting the spring.jpa.show-sql property
 * to true.
 * This can be disabled using the showSql attribute.
 * 
 * If you are looking to load your full application configuration,
 * but use an embedded database, you should consider @SpringBootTest
 * combined with @AutoConfigureTestDatabase rather than this annotation.
 * 
 * Read more about test slicing: https://reflectoring.io/spring-boot-test/
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

    @Test
    public void testsave() {
        // given
        OrganisationEntity organisation = new OrganisationEntity();
        organisation.setName("myOrganisation");
        // when
        repository.save(organisation);
        List<OrganisationEntity> organisations = repository.findByName("myOrganisation");
        // then
        assertTrue(!organisations.isEmpty());
        assertEquals(1, organisations.size());
        assertEquals(42L, organisation.getLonglongNumber());
    }
}
