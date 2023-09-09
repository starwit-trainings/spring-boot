package de.starwit.batchexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

public class ArticleItemProcessor implements ItemProcessor<Article, Article> {

  private static final Logger log = LoggerFactory.getLogger(ArticleItemProcessor.class);

  @Override
  public Article process(final @NonNull Article article) throws Exception {

    final Article transformedArticle = new Article();
    transformedArticle.setColor(article.getColor());
    transformedArticle.setName(article.getName());
    transformedArticle.setPrice(article.getPrice());
    transformedArticle.setWeight(article.getWeight());

    log.info("Converting (" + article + ") into (" + transformedArticle + ")");

    return transformedArticle;
  }

}
