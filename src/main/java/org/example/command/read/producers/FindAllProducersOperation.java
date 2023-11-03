package org.example.command.read.producers;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;


public class FindAllProducersOperation implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());
    @Override
    public String execute() {
        return producerService.findAll().toString();
    }
}
