package fr.digi.m062024.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "petstore")
public class PetStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "manager_name", length = 50, nullable = false)
    private String managerName;

    //  RELATIONS

    //  PETSTORE -> PRODUCT
    @ManyToMany
    @JoinTable(name = "petstore_products",
            joinColumns = @JoinColumn(name = "id_petstore", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"))
    private Set<Product> products;


    //  PETSTORE -> ADDRESS
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    //  PETSTORE -> ANIMAL
    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;


    //  BLOC D'INITIALISATION DES SETS
    {
        products = new HashSet<>();
        animals = new HashSet<>();
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public PetStore() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", address=").append(address);
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
     * Getter for name.
     *
     * @return the value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param value the new value for name.
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Getter for managerName.
     *
     * @return the value of managerName.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter for managerName.
     *
     * @param value the new value for managerName.
     */
    public void setManagerName(String value) {
        this.managerName = value;
    }

    /**
     * Getter for products.
     *
     * @return the value of products.
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Setter for products.
     *
     * @param value the new value for products.
     */
    public void setProducts(Set<Product> value) {
        this.products = value;
    }

    /**
     * Allows to add a product to a petstore
     *
     * @param product
     */
    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            product.getPetStores().add(this);
        }
    }

    /**
     * Allows to add a product from a petstore
     *
     * @param product
     */
    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        }
    }

    /**
     * Getter for address.
     *
     * @return the value of address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for address.
     *
     * @param value the new value for address.
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Getter for animals.
     *
     * @return the value of animals.
     */
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Setter for animals.
     *
     * @param value the new value for animals.
     */
    public void setAnimals(Set<Animal> value) {
        this.animals = value;
    }

    /**
     * Allows to add an animal to a petstore
     *
     * @param animal
     */
    public void addAnimal(Animal animal) {
        if (animal != null) {
            this.animals.add(animal);
            animal.setPetStore(this);
        }
    }

    /**
     * Allows to remove an animal from a petstore
     *
     * @param animal
     */
    public void removeAnimal(Animal animal) {
        if (animal != null) {
            this.animals.remove(animal);
            animal.setPetStore(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetStore petStore = (PetStore) o;
        return Objects.equals(id, petStore.id) && Objects.equals(name, petStore.name) && Objects.equals(managerName, petStore.managerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, managerName);
    }
}
