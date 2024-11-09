package fr.digi.m062024.entities;

public enum ProdType {

    FOOD("Food"),
    ACCESSORY("Accesory"),
    CLEANING("Cleaning");

    private String name;

    private ProdType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProdType{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
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
}
