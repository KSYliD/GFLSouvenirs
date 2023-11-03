package org.example.repositories;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Producer;
import org.example.entities.Souvenir;


import java.io.*;
import java.util.*;

import java.util.stream.Collectors;


public class SouvenirRepositoryImpl implements SouvenirRepository {
    private static final String PATH = "data/souvenirs.json";
    private static SouvenirRepository instance;

    private SouvenirRepositoryImpl() {
    }
    public static SouvenirRepository getInstance() {
        if (instance == null) {
            instance = new SouvenirRepositoryImpl();
        }
        return instance;
    }
    @Override
    public List<Souvenir> findAll() {
        try (FileReader fr = new FileReader(PATH);
             BufferedReader br = new BufferedReader(fr)) {

            String data = br.lines().collect(Collectors.joining());
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            Souvenir[] souvenirs = mapper.readValue(data, Souvenir[].class);

            return Arrays.stream(souvenirs)
                    .map(s -> new Souvenir(
                            s.getId(),
                            s.getName(),
                            s.getProducerId(),
                            s.getYear(),
                            s.getPrice()
                    ))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Souvenir> findByProducer(Producer producer) {
        return findAll()
                .stream()
                .filter(souvenir -> souvenir.getProducerId() == producer.getId())
                .toList();
    }

    @Override
    public List<Souvenir> findByYear(int year) {
        return findAll().stream().filter(souvenir -> souvenir.getYear() == year).toList();
    }

    @Override
    public void createSouvenir(Souvenir souvenir) {
        List<Souvenir> souvenirs = new ArrayList<>(findAll());
        souvenirs.add(souvenir);
        createSouvenirs(souvenirs);
    }

    private void createSouvenirs(List<Souvenir> souvenirs) {
        try (FileWriter fw = new FileWriter(PATH);
             BufferedWriter bw = new BufferedWriter(fw)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            String data = mapper.writeValueAsString(
                    souvenirs.stream()
                            .map(s -> new Souvenir(
                                    s.getId(),
                                    s.getName(),
                                    s.getProducerId(),
                                    s.getYear(),
                                    s.getPrice()
                            ))
                            .toList()
            );
            bw.write(data);
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSouvenir(Souvenir souvenir) {
        List<Souvenir> list = new ArrayList<>(findAll());
        int index = findIndexOfSouvenir(list, souvenir);
        if (index >= 0) {
            list.set(index, souvenir);
            createSouvenirs(list);
        } else throw new IllegalArgumentException("there is no such souvenir");

    }

    private Souvenir findById(long id) {
        List<Souvenir> souvenirs = new ArrayList<>(findAll());
        return souvenirs.stream().filter(souvenir -> souvenir.getId() == id).findAny().orElseThrow();
    }

    @Override
    public void deleteSouvenir(Souvenir souvenir) {
        List<Souvenir> list = new ArrayList<>(findAll());
        int index = findIndexOfSouvenir(list, souvenir);
        if (index >= 0) {
            list.remove(index);
            createSouvenirs(list);
        } else throw new IllegalArgumentException("there is no such souvenir");
    }

    private int findIndexOfSouvenir(List<Souvenir> list, Souvenir souvenir) {
        Souvenir theSouvenir = findById(souvenir.getId());
        return list.indexOf(list.stream().filter(souvenirs -> souvenirs.equals(theSouvenir)).findAny().orElseThrow());
    }
}
