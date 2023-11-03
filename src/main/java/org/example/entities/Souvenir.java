package org.example.entities;

import java.util.Objects;

public class Souvenir {
    private long id;
    private String name;
    private long producerId;
    private int year;
    private int price;

    public Souvenir() {
    }

    public Souvenir(long id) {
        this.id = id;
    }

    public Souvenir(long id, String name, long producerId, int year, int price) {
        this.id = id;
        this.name = name;
        this.producerId = producerId;
        this.year = year;
        this.price = price;
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

    public long getProducerId() {
        return producerId;
    }

    public void setProducerId(long producerId) {
        this.producerId = producerId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souvenir souvenir = (Souvenir) o;
        return id == souvenir.id && producerId == souvenir.producerId && year == souvenir.year && price == souvenir.price && Objects.equals(name, souvenir.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producerId, year, price);
    }

    @Override
    public String toString() {
        return "Souvenir: " + "id = " + id + " name = " + name + ", producer Id = " +
                producerId + ", date = " + year +", price = " + price +';';
    }

    public static class SouvenirBuilder{
        private final Souvenir souvenir = new Souvenir();

        public SouvenirBuilder(long id, String name) {
            souvenir.id = id;
            souvenir.name = name;
        }

        public SouvenirBuilder producerId(long producerId){
            souvenir.producerId = producerId;
            return this;
        }
        public SouvenirBuilder year(int year){
            souvenir.year = year;
            return this;
        }
        public SouvenirBuilder price(int price){
            souvenir.price = price;
            return this;
        }
        public Souvenir build(){
            return souvenir;
        }
    }
}
