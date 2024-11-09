package fr.digi.m062024.entities;

public enum FishLivEnv {

    FRESH_WATER("Fresh_Water"),
    SEA_WATER("Sea_Water");

    private String name;


    private FishLivEnv(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FishLivEnv{");
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
