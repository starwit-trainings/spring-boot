package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Organisation Entity class
 */
@Entity
@Table(name = "organisation")
public class OrganisationEntity extends AbstractEntity<Long> {

    // entity fields
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "longlongnumber")
    private Long longlongNumber;


    @Column(name = "somebigdecimal")
    private BigDecimal someBigDecimal;


    @Column(name = "thedoulbebugfix")
    private Double theDoulbeBugfix;


    // entity relations
    @JsonFilter("filterId")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private AddressEntity address;

    @JsonFilter("filterId")
    @ManyToMany(mappedBy = "organisation")
    private Set<MyUserEntity> user;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLonglongNumber() {
        return longlongNumber;
    }

    public void setLonglongNumber(Long longlongNumber) {
        this.longlongNumber = longlongNumber;
    }

    public BigDecimal getSomeBigDecimal() {
        return someBigDecimal;
    }

    public void setSomeBigDecimal(BigDecimal someBigDecimal) {
        this.someBigDecimal = someBigDecimal;
    }

    public Double getTheDoulbeBugfix() {
        return theDoulbeBugfix;
    }

    public void setTheDoulbeBugfix(Double theDoulbeBugfix) {
        this.theDoulbeBugfix = theDoulbeBugfix;
    }

    // entity relations getters and setters
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<MyUserEntity> getUser() {
        return user;
    }

    public void setUser(Set<MyUserEntity> user) {
        this.user = user;
    }

}
