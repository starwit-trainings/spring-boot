package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Cart Entity class
 */
@Entity
@Table(name = "cart")
public class CartEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name="created")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime created;


    // entity relations
    @JsonFilter("filterId")
    @OneToMany(mappedBy = "cart")
    private Set<ArticleEntity> article;

    // entity fields getters and setters
    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    // entity relations getters and setters
    public Set<ArticleEntity> getArticle() {
        return article;
    }

    public void setArticle(Set<ArticleEntity> article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "CartEntity [created=" + created + ", article=" + article.size() + "]";
    }

}
