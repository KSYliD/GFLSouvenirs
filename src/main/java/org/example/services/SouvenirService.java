package org.example.services;

import org.example.entities.Producer;
import org.example.entities.Souvenir;

import java.util.List;

public interface SouvenirService {
    List<Souvenir> findAll();

    List<Souvenir> findByCountry(String country);

    List<Souvenir> findByProducer(Producer producer);

    List<Souvenir> findByYear(int year);

    void createSouvenir(Souvenir souvenir);

    void updateSouvenir(Souvenir souvenir);

    void deleteSouvenir(Souvenir souvenir);
}
