package de.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.user.persistence.entity.ArticleEntity;
import de.user.service.ArticleDTO;
import de.user.service.CartBean;
import de.user.service.CartDTO;

@Service
public class CartManagementService {
    
    @Autowired
    private CartBean cartBean;

    public void addArticleToCart(ArticleEntity entity) {
        ArticleDTO newArticle = new ArticleDTO();
        newArticle.setName(entity.getName());
        newArticle.setColor(entity.getColor());
        newArticle.setPrice(entity.getPrice());
        newArticle.setWeight(entity.getWeight());
        cartBean.getArticles().add(newArticle);
    }

    public void checkOut() {
        /*
         * TODO
         * 
         * save Cart + Articles to DB
         * handle case that articles already present/not present
         * reset session bean
         */
    }

    public void resetCart() {
        // TODO
    }

    public CartDTO getCartBean() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setArticles(cartBean.getArticles());
        cartDTO.setNumber(cartBean.getNumber());
        cartDTO.setCreatedDate(cartBean.getCreatedDate());
        return cartDTO;
    }
}
