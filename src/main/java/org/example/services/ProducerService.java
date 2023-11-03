package org.example.services;

import org.example.entities.Producer;
import org.example.entities.Souvenir;

import java.util.List;
import java.util.Map;

public interface ProducerService {
    Map<Producer, List<Souvenir>> findEverything();
    void createProducer(Producer producer);
    List<Producer> findAll();
    void updateProducer(Producer producer);
    void deleteProducerAndHisSouvenirs(Producer producer);
    List<Producer> findByPriseLessThan(int price);
    List<Producer> findBySouvenirInSuchYear(int year);

}
