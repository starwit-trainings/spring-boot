package de.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;

public class CartBean {

    private List<ArticleDTO> articles;

    private int number;

    private Date createdDate;

    @PostConstruct
    public void init() {
        articles = new ArrayList<>();
        createdDate = new Date();
        number = (int) ((Math.random() * (500 - 1)) + 1);
    }

    public void reset() {
        /*
         * called after checkout
         * empty articles
         * create new timestamp
         * generate new random number
         */
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public int getNumber() {
        return number;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    
}
