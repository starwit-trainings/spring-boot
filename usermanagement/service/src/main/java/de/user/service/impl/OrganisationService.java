package de.user.service.impl;
import java.util.List;
import de.user.persistence.entity.OrganisationEntity;
import de.user.persistence.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Organisation Service class
 *
 */
@Service
public class OrganisationService implements ServiceInterface<OrganisationEntity, OrganisationRepository> {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationRepository getRepository() {
        return organisationRepository;
    }

    public List<OrganisationEntity> findAllWithoutAddress() {
        return organisationRepository.findAllWithoutAddress();
    }

    public List<OrganisationEntity> findAllWithoutOtherAddress(Long id) {
        return organisationRepository.findAllWithoutOtherAddress(id);
    }

}
