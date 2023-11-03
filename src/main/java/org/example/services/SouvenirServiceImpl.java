package org.example.services;

import org.example.entities.Producer;
import org.example.entities.Souvenir;
import org.example.repositories.ProducerRepository;
import org.example.repositories.SouvenirRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SouvenirServiceImpl implements SouvenirService {
    private final SouvenirRepository souvenirRepository;
    private final ProducerRepository producerRepository;

    public SouvenirServiceImpl(SouvenirRepository souvenirRepository, ProducerRepository producerRepository) {
        this.souvenirRepository = souvenirRepository;
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Souvenir> findAll() {
        return souvenirRepository.findAll();
    }

    @Override
    public List<Souvenir> findByCountry(String country) {
        List<Producer> producersOfSuchACountry = producerRepository.findAll()
                .stream()
                .filter(producer -> producer.getCountry().equals(country))
                .toList();
        return producersOfSuchACountry
                .stream()
                .map(this::findByProducer)
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public List<Souvenir> findByProducer(Producer producer) {
        return souvenirRepository.findByProducer(producer);
    }

    @Override
    public List<Souvenir> findByYear(int year) {
        return souvenirRepository.findByYear(year);
    }

    @Override
    public void createSouvenir(Souvenir souvenir) {
        List<Souvenir> list = new ArrayList<>(findAll());
        if (list.stream().noneMatch(listElement -> listElement.getId() == souvenir.getId())) {
            souvenirRepository.createSouvenir(souvenir);
        } else {
            throw new IllegalArgumentException("Souvenir with such id exist");
        }
    }


    @Override
    public void updateSouvenir(Souvenir souvenir) {
        souvenirRepository.updateSouvenir(souvenir);
    }

    @Override
    public void deleteSouvenir(Souvenir souvenir) {
        souvenirRepository.deleteSouvenir(souvenir);
    }
}
