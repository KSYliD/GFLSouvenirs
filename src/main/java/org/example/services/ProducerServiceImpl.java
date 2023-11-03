package org.example.services;

import org.example.entities.Producer;
import org.example.entities.Souvenir;
import org.example.repositories.ProducerRepository;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepository;


import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ProducerServiceImpl implements ProducerService {
    private static final String PATH = "data/producers.json";
    private final ProducerRepository producerRepository;
    private final SouvenirRepository souvenirRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository, SouvenirRepository souvenirRepository) {
        this.producerRepository = producerRepository;
        this.souvenirRepository = souvenirRepository;
    }

    @Override
    public Map<Producer, List<Souvenir>> findEverything() {
        Map<Producer, List<Souvenir>> map = new HashMap<>();
        findAll().forEach(producer -> map.put(producer, souvenirRepository.findByProducer(producer)));
        return map;
    }

    @Override
    public void createProducer(Producer producer) {
        List<Producer> list = new ArrayList<>(findAll());
        if (list.stream().noneMatch(listElement -> listElement.getId() == producer.getId())) {
            producerRepository.createProducer(producer);
        } else {
            throw new IllegalArgumentException("Producer with such id exist");
        }
    }

    @Override
    public List<Producer> findAll() {
        if (new File("data/producers.json").length() == 0) {
            throw new IllegalArgumentException("the file is empty, please rewrite the logic");
        }
        return producerRepository.findAll();
    }

    @Override
    public void updateProducer(Producer producer) {
        producerRepository.updateProducer(producer);
    }

    @Override
    public void deleteProducerAndHisSouvenirs(Producer producer) {
        souvenirRepository.findByProducer(producer)
                .forEach(souvenirRepository::deleteSouvenir);
        deleteProducer(producer);
    }

    private void deleteProducer(Producer producer) {
        List<Producer> list = new ArrayList<>(findAll());
        int index = findIndexOfProducer(list, producer);
        if (index >= 0) {
            list.remove(index);
            createProducers(list);
        } else throw new IllegalArgumentException("there is no such souvenir");
    }

    private int findIndexOfProducer(List<Producer> list, Producer producer) {
        Producer optionalSouvenir = findById(producer.getId());
        return list.indexOf(list.stream()
                .filter(souvenirs -> souvenirs.equals(optionalSouvenir))
                .findAny()
                .orElseThrow());
    }

    private Producer findById(long id) {
        return findAll().stream().filter(producer -> producer.getId() == id).findAny().orElseThrow();
    }

    private void createProducers(List<Producer> producers) {
        ProducerRepositoryImpl.addProducers(producers, PATH);
    }

    @Override
    public List<Producer> findByPriseLessThan(int price) {
        List<Souvenir> souvenirs = souvenirRepository.findAll();
        if (souvenirs.isEmpty()) {
            return Collections.emptyList();
        }

        return souvenirs.stream()
                .filter(souvenir -> souvenir.getPrice() < price)
                .map(souvenir -> findById(souvenir.getProducerId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producer> findBySouvenirInSuchYear(int year) {
        return souvenirRepository.findByYear(year)
                .stream()
                .map(souvenir -> findById(souvenir.getProducerId()))
                .collect(Collectors.toList());
    }
}
