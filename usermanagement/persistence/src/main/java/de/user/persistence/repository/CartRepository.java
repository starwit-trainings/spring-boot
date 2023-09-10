package de.user.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.user.persistence.entity.CartEntity;

/**
 * Cart Repository class
 */
@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
