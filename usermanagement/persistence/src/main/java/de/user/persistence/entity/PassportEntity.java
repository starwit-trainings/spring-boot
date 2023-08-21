package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Passport Entity class
 */
@Entity
@Table(name = "passport")
public class PassportEntity extends AbstractEntity<Long> {

    // entity fields
    @NotNull
    @Column(name = "passportid", nullable = false)
    private Integer passportId;


    @Column(name="datecreated")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime dateCreated;


    @Column(name="sometime")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime someTime;


    @Column(name="logtime")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime logTime;


    // entity relations
    @JsonFilter("filterId")
    @ManyToOne
    @JoinColumn(name = "myuser_id")
    private MyUserEntity user;

    // entity fields getters and setters
    public Integer getPassportId() {
        return passportId;
    }

    public void setPassportId(Integer passportId) {
        this.passportId = passportId;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ZonedDateTime getSomeTime() {
        return someTime;
    }

    public void setSomeTime(ZonedDateTime someTime) {
        this.someTime = someTime;
    }

    public ZonedDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(ZonedDateTime logTime) {
        this.logTime = logTime;
    }

    // entity relations getters and setters
    public MyUserEntity getUser() {
        return user;
    }

    public void setUser(MyUserEntity user) {
        this.user = user;
    }

}
