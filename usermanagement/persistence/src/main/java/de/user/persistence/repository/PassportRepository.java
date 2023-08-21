package de.user.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.user.persistence.entity.PassportEntity;

/**
 * Passport Repository class
 */
@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, Long> {

    @Query("SELECT e FROM PassportEntity e WHERE NOT EXISTS (SELECT r FROM e.user r)")
    public List<PassportEntity> findAllWithoutUser();

    @Query("SELECT e FROM PassportEntity e WHERE NOT EXISTS (SELECT r FROM e.user r WHERE r.id <> ?1)")
    public List<PassportEntity> findAllWithoutOtherUser(Long id);
}
