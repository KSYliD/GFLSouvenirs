package org.example.repositories;

import org.example.entities.Producer;
import org.example.entities.Souvenir;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProducerRepository {
    void createProducer(Producer producer);
    List<Producer> readAll();
    void updateProducer(Producer producer);

}
