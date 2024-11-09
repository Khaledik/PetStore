package fr.digi.m062024.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "fish")
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    @Column(name = "living_env")
    private FishLivEnv livingEnv;

    public Fish(LocalDate birthDate, String color, FishLivEnv livingEnv) {
        super(birthDate, color);
        this.livingEnv = livingEnv;
    }

    public Fish() {
    }

    /**
     * Getter for livingEnv.
     *
     * @return the value of livingEnv.
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Setter for livingEnv.
     *
     * @param value the new value for livingEnv.
     */
    public void setLivingEnv(FishLivEnv value) {
        this.livingEnv = value;
    }
}
