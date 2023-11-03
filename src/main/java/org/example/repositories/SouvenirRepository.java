package org.example.repositories;

import org.example.entities.Producer;
import org.example.entities.Souvenir;

import java.util.List;

public interface SouvenirRepository {
    List<Souvenir> findAll();
    List<Souvenir> findByProducer(Producer producer);
    List<Souvenir> findByYear(int year);
    void createSouvenir(Souvenir souvenir);
    void updateSouvenir(Souvenir souvenir);
    void deleteSouvenir(Souvenir souvenir);

}
