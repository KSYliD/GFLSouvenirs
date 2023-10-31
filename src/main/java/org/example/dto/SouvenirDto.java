package org.example.dto;

public class Souvenir {
    private String name;
    private ProducerDTO producer;
    private String date;
    private int price;

    public Souvenir() {
    }

    public Souvenir(String name, ProducerDTO producer, String date, int price) {
        this.name = name;
        this.producer = producer;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProducerDTO getProducer() {
        return producer;
    }

    public void setProducer(ProducerDTO producer) {
        this.producer = producer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir: " + "name = " + name + ", producer = " + producer + ", date = " + date +", price = " + price +';';
    }
}
