package de.user.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.user.persistence.entity.OrganisationEntity;
import de.user.persistence.repository.OrganisationRepository;

/**
 * Mockito tests: when testing complicated business logic,
 * it can be faster to mock parts of the service,
 * e.g. writing and reading to repositories via database
 * see
 * https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/
 */
@ExtendWith(MockitoExtension.class)
public class OrganisationServiceTest {

    @InjectMocks
    OrganisationService service;

    @Mock
    OrganisationRepository repository;

    @Test
    void testFindAllOrganinsations() {
        List<OrganisationEntity> list = new ArrayList<OrganisationEntity>();
        OrganisationEntity orgOne = new OrganisationEntity();
        orgOne.setName("orgOne");
        OrganisationEntity orgTwo = new OrganisationEntity();
        orgTwo.setName("orgTwo");
        OrganisationEntity orgThree = new OrganisationEntity();
        orgThree.setName("orgThree");

        list.add(orgOne);
        list.add(orgTwo);
        list.add(orgThree);

        when(repository.findAll()).thenReturn(list);

        // test
        List<OrganisationEntity> orgList = service.findAll();

        assertEquals(3, orgList.size());
        verify(repository, times(1)).findAll();
    }

    // Having fun with mocks: mocking the repository, I returned back orgTwo instead
    // of orgOne when saving via repository
    @Test
    void testCreateOrSaveOrganisation() {
        OrganisationEntity orgOne = new OrganisationEntity();
        orgOne.setName("orgOne");

        service.saveOrUpdate(orgOne);

        OrganisationEntity orgTwo = new OrganisationEntity();
        orgTwo.setName("orgTwo");

        when(repository.save(orgOne)).thenReturn(orgTwo);

        // verify numbers of interactions with the mock
        verify(repository, times(1)).save(orgOne);
        OrganisationEntity resultEntity = service.saveOrUpdate(orgOne);
        assertEquals("orgTwo", resultEntity.getName());

    }
}
