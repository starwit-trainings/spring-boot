package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * MyUser Entity class
 */
@Entity
@Table(name = "myuser")
public class MyUserEntity extends AbstractEntity<Long> {

    // entity fields
    @NotBlank
    @Column(name = "firstname", nullable = false)
    private String firstName;


    @NotBlank
    @Column(name = "lastname", nullable = false)
    private String lastName;


    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;


    @Column(name = "isrich")
    private Boolean isRich;


    @Column(name = "title")
    private String title;


    // entity relations
    @JsonFilter("filterId")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private AddressEntity address;

    @JsonFilter("filterId")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
        name = "myuser_organisation",
        joinColumns = @JoinColumn(name = "myuser_id"),
        inverseJoinColumns = @JoinColumn(name = "organisation_id"))
    private Set<OrganisationEntity> organisation;

    @JsonFilter("filterId")
    @OneToMany(mappedBy = "user")
    private Set<PassportEntity> passport;

    // entity fields getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getIsRich() {
        return isRich;
    }

    public void setIsRich(Boolean isRich) {
        this.isRich = isRich;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // entity relations getters and setters
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<OrganisationEntity> getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Set<OrganisationEntity> organisation) {
        this.organisation = organisation;
    }

    public Set<PassportEntity> getPassport() {
        return passport;
    }

    public void setPassport(Set<PassportEntity> passport) {
        this.passport = passport;
    }

}
