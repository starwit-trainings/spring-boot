package de.user.service.impl;
import java.util.List;
import de.user.persistence.entity.ArticleEntity;
import de.user.persistence.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Article Service class
 *
 */
@Service
public class ArticleService implements ServiceInterface<ArticleEntity, ArticleRepository> {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleRepository getRepository() {
        return articleRepository;
    }

    public List<ArticleEntity> findAllWithoutCart() {
        return articleRepository.findAllWithoutCart();
    }

    public List<ArticleEntity> findAllWithoutOtherCart(Long id) {
        return articleRepository.findAllWithoutOtherCart(id);
    }

}
