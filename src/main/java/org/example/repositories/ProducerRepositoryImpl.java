package org.example.repositories;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Producer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ProducerRepositoryImpl implements ProducerRepository {
    private static final String PATH = "data/producers.json";

    @Override
    public void createProducer(Producer producer) {
        List<Producer> producers = new ArrayList<>(readAll());
        producers.add(producer);
        createProducers(producers);
    }

    @Override
    public List<Producer> readAll() {
        try (FileReader fr = new FileReader(PATH);
             BufferedReader br = new BufferedReader(fr)) {

            String data = br.lines().collect(Collectors.joining());
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            Producer[] producers = mapper.readValue(data, Producer[].class);

            return Arrays.stream(producers).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProducer(Producer producer) {
        List<Producer> list = new ArrayList<>(readAll());
        Optional<Producer> optionalProducer = findById(producer.getId());
        if (optionalProducer.isPresent()) {
            Producer tempProducer = optionalProducer.get();
            int index = list.indexOf(list.stream().filter(user -> user.equals(tempProducer)).findAny().orElseThrow());
            if (index >= 0) {
                list.set(index, producer);
                createProducers(list);
            } else System.out.println("there is no such user");
        }
    }

    private Optional<Producer> findById(long id) {
        return readAll().stream().filter(producer -> producer.getId() == id).findAny();
    }

    private void createProducers(List<Producer> producers) {
        addProducers(producers, PATH);
    }

    public static void addProducers(List<Producer> producers, String path) {
        try (FileWriter fw = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(fw)) {

            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(producers);
            bw.write(data);
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
