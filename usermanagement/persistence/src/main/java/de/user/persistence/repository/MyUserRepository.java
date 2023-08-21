package de.user.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.user.persistence.entity.MyUserEntity;

/**
 * MyUser Repository class
 */
@Repository
public interface MyUserRepository extends JpaRepository<MyUserEntity, Long> {

    @Query("SELECT e FROM MyUserEntity e WHERE NOT EXISTS (SELECT r FROM e.address r)")
    public List<MyUserEntity> findAllWithoutAddress();

    @Query("SELECT e FROM MyUserEntity e WHERE NOT EXISTS (SELECT r FROM e.address r WHERE r.id <> ?1)")
    public List<MyUserEntity> findAllWithoutOtherAddress(Long id);
}
