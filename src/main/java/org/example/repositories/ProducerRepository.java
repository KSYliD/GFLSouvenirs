package org.example.repositories;

import org.example.entities.Producer;

import java.util.List;

public interface ProducerRepository {
    void createProducer(Producer producer);
    List<Producer> readAll();
    void updateProducer(Producer producer);

}
