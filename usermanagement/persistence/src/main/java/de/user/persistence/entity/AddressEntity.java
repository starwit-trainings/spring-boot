package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Address Entity class
 */
@Entity
@Table(name = "address")
public class AddressEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name = "city")
    private String city;


    @Column(name = "street")
    private String street;


    @Column(name = "streetnr")
    private String streetNr;


    @Column(name = "citycode")
    private String cityCode;


    // entity relations
    @OneToOne(mappedBy = "address")
    private OrganisationEntity organisation;

    @OneToOne(mappedBy = "address")
    private MyUserEntity user;

    // entity fields getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    // entity relations getters and setters
    public OrganisationEntity getOrganisation() {
        return organisation;
    }

    public void setOrganisation(OrganisationEntity organisation) {
        this.organisation = organisation;
    }

    public MyUserEntity getUser() {
        return user;
    }

    public void setUser(MyUserEntity user) {
        this.user = user;
    }

}
