package fr.digi.m062024.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private Long id;

    @Column(name = "number", length = 10, nullable = false)
    private String number;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    //  RELATIONS

    //  ADDRESS -> PETSTORE
    @OneToOne(mappedBy = "address")
    private PetStore petStore;


    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Getter for id.
     *
     * @return the value of id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param value the new value for id.
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Getter for number.
     *
     * @return the value of number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param value the new value for number.
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Getter for street.
     *
     * @return the value of street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for street.
     *
     * @param value the new value for street.
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Getter for zipCode.
     *
     * @return the value of zipCode.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter for zipCode.
     *
     * @param value the new value for zipCode.
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Getter for city.
     *
     * @return the value of city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city.
     *
     * @param value the new value for city.
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Getter for petStore.
     *
     * @return the value of petStore.
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Setter for petStore.
     *
     * @param value the new value for petStore.
     */
    public void setPetStore(PetStore value) {
        this.petStore = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(number, address.number) && Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, street, zipCode, city);
    }
}
