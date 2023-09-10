package de.user.service.impl;
import de.user.persistence.entity.CartEntity;
import de.user.persistence.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.user.persistence.entity.ArticleEntity;
import de.user.persistence.repository.ArticleRepository;

/**
 * 
 * Cart Service class
 *
 */
@Service
public class CartService implements ServiceInterface<CartEntity, CartRepository> {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public CartRepository getRepository() {
        return cartRepository;
    }


    @Override
    public CartEntity saveOrUpdate(CartEntity entity) {

        Set<ArticleEntity> articleToSave = entity.getArticle();

        if (entity.getId() != null) {
            CartEntity entityPrev = this.findById(entity.getId());
            for (ArticleEntity item : entityPrev.getArticle()) {
                ArticleEntity existingItem = articleRepository.getById(item.getId());
                existingItem.setCart(null);
                this.articleRepository.save(existingItem);
            }
        }

        entity.setArticle(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (articleToSave != null && !articleToSave.isEmpty()) {
            for (ArticleEntity item : articleToSave) {
                ArticleEntity newItem = articleRepository.getById(item.getId());
                newItem.setCart(entity);
                articleRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
