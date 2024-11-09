package fr.digi.m062024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "chip_id")
    private String chipId;

    public Cat(LocalDate birthDate, String color, String chipId) {
        super(birthDate, color);
        this.chipId = chipId;
    }

    public Cat() {
    }

    /**
     * Getter for chipId.
     *
     * @return the value of chipId.
     */
    public String getChipId() {
        return chipId;
    }

    /**
     * Setter for chipId.
     *
     * @param value the new value for chipId.
     */
    public void setChipId(String value) {
        this.chipId = value;
    }
}
