package de.user.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.user.persistence.entity.AddressEntity;

/**
 * Address Repository class
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT e FROM AddressEntity e WHERE NOT EXISTS (SELECT r FROM e.organisation r)")
    public List<AddressEntity> findAllWithoutOrganisation();

    @Query("SELECT e FROM AddressEntity e WHERE NOT EXISTS (SELECT r FROM e.organisation r WHERE r.id <> ?1)")
    public List<AddressEntity> findAllWithoutOtherOrganisation(Long id);
    @Query("SELECT e FROM AddressEntity e WHERE NOT EXISTS (SELECT r FROM e.user r)")
    public List<AddressEntity> findAllWithoutUser();

    @Query("SELECT e FROM AddressEntity e WHERE NOT EXISTS (SELECT r FROM e.user r WHERE r.id <> ?1)")
    public List<AddressEntity> findAllWithoutOtherUser(Long id);
}
