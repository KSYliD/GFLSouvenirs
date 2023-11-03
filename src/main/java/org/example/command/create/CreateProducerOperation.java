package org.example.command.create;

import org.example.Main;
import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;

public class CreateProducerOperation implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());

    @Override
    public String execute() {
        producerService.createProducer(Main.producerInput());
        return "Producer has been created successfully";
    }
}
