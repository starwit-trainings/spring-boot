package de.user.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.user.persistence.entity.OrganisationEntity;

/**
 * Organisation Repository class
 */
public interface OrganisationRepository extends JpaRepository<OrganisationEntity, Long> {

    @Query("SELECT e FROM OrganisationEntity e WHERE NOT EXISTS (SELECT r FROM e.address r)")
    public List<OrganisationEntity> findAllWithoutAddress();

    @Query("SELECT e FROM OrganisationEntity e WHERE NOT EXISTS (SELECT r FROM e.address r WHERE r.id <> ?1)")
    public List<OrganisationEntity> findAllWithoutOtherAddress(Long id);

    public List<OrganisationEntity> findByName(String name);
}
