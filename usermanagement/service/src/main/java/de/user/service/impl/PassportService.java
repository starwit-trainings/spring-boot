package de.user.service.impl;
import java.util.List;
import de.user.persistence.entity.PassportEntity;
import de.user.persistence.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Passport Service class
 *
 */
@Service
public class PassportService implements ServiceInterface<PassportEntity, PassportRepository> {

    @Autowired
    private PassportRepository passportRepository;

    @Override
    public PassportRepository getRepository() {
        return passportRepository;
    }

    public List<PassportEntity> findAllWithoutUser() {
        return passportRepository.findAllWithoutUser();
    }

    public List<PassportEntity> findAllWithoutOtherUser(Long id) {
        return passportRepository.findAllWithoutOtherUser(id);
    }

}
