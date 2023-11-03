package org.example.command.read;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;


public class FindEverythingOperation implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());
    @Override
    public String execute() {
        return producerService.findEverything().toString();
    }
}
