package fr.digi.m062024.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    private Long id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "color", length = 50, nullable = false)
    private String color;

    //  RELATION

    //  ANIMAL -> PETSTORE
    @ManyToOne
    @JoinColumn(name = "id_petstore")
    private PetStore petStore;

    public Animal(LocalDate birthDate, String color) {
        this.birthDate = birthDate;
        this.color = color;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", color='").append(color).append('\'');
        sb.append(", petStore=").append(petStore);
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
     * Getter for birthDate.
     *
     * @return the value of birthDate.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter for birthDate.
     *
     * @param value the new value for birthDate.
     */
    public void setBirthDate(LocalDate value) {
        this.birthDate = value;
    }

    /**
     * Getter for color.
     *
     * @return the value of color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for color.
     *
     * @param value the new value for color.
     */
    public void setColor(String value) {
        this.color = value;
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
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(birthDate, animal.birthDate) && Objects.equals(color, animal.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthDate, color);
    }
}
