package org.example.entities;


import java.util.Objects;

public class Producer {
    private long id;
    private String name;
    private String country;

    public Producer() {
    }

    public Producer(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id == producer.id && Objects.equals(name, producer.name) && Objects.equals(country, producer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "Producer = id: " + id + ", name = " + name + ", country = " + country + '}'+ '\n';
    }
}
