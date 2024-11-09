package fr.digi.m062024.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private Long id;

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "label", length = 50, nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 10, nullable = false)
    private ProdType type;

    @Column(name = "price", length = 10, nullable = false)
    private Double price;

    //  RELATION

    //  PRODUCT -> PETSTORE
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    {
        petStores = new HashSet<>();
    }


    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
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
     * Getter for code.
     *
     * @return the value of code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for code.
     *
     * @param value the new value for code.
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Getter for label.
     *
     * @return the value of label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter for label.
     *
     * @param value the new value for label.
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Getter for type.
     *
     * @return the value of type.
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter for type.
     *
     * @param value the new value for type.
     */
    public void setType(ProdType value) {
        this.type = value;
    }

    /**
     * Getter for price.
     *
     * @return the value of price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter for price.
     *
     * @param value the new value for price.
     */
    public void setPrice(Double value) {
        this.price = value;
    }

    /**
     * Getter for petStores.
     *
     * @return the value of petStores.
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter for petStores.
     *
     * @param value the new value for petStores.
     */
    public void setPetStores(Set<PetStore> value) {
        this.petStores = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(label, product.label) && type == product.type && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, label, type, price);
    }
}
