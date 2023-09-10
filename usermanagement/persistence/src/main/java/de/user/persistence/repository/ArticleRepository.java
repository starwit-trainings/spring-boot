package de.user.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.user.persistence.entity.ArticleEntity;

/**
 * Article Repository class
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    @Query("SELECT e FROM ArticleEntity e WHERE NOT EXISTS (SELECT r FROM e.cart r)")
    public List<ArticleEntity> findAllWithoutCart();

    @Query("SELECT e FROM ArticleEntity e WHERE NOT EXISTS (SELECT r FROM e.cart r WHERE r.id <> ?1)")
    public List<ArticleEntity> findAllWithoutOtherCart(Long id);
}
