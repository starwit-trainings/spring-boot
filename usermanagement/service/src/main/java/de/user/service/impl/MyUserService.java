package de.user.service.impl;
import java.util.List;
import de.user.persistence.entity.MyUserEntity;
import de.user.persistence.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.user.persistence.entity.PassportEntity;
import de.user.persistence.repository.PassportRepository;

/**
 * 
 * MyUser Service class
 *
 */
@Service
public class MyUserService implements ServiceInterface<MyUserEntity, MyUserRepository> {

    @Autowired
    private MyUserRepository myuserRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Override
    public MyUserRepository getRepository() {
        return myuserRepository;
    }

    public List<MyUserEntity> findAllWithoutAddress() {
        return myuserRepository.findAllWithoutAddress();
    }

    public List<MyUserEntity> findAllWithoutOtherAddress(Long id) {
        return myuserRepository.findAllWithoutOtherAddress(id);
    }

    @Override
    public MyUserEntity saveOrUpdate(MyUserEntity entity) {

        Set<PassportEntity> passportToSave = entity.getPassport();

        if (entity.getId() != null) {
            MyUserEntity entityPrev = this.findById(entity.getId());
            for (PassportEntity item : entityPrev.getPassport()) {
                PassportEntity existingItem = passportRepository.getById(item.getId());
                existingItem.setUser(null);
                this.passportRepository.save(existingItem);
            }
        }

        entity.setPassport(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (passportToSave != null && !passportToSave.isEmpty()) {
            for (PassportEntity item : passportToSave) {
                PassportEntity newItem = passportRepository.getById(item.getId());
                newItem.setUser(entity);
                passportRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
