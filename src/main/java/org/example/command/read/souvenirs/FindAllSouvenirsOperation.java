package org.example.command.read.souvenirs;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.SouvenirService;
import org.example.services.SouvenirServiceImpl;

public class FindAllSouvenirsOperation implements MethodExecutor {
    private final SouvenirService souvenirService =
            new SouvenirServiceImpl(SouvenirRepositoryImpl.getInstance(), ProducerRepositoryImpl.getInstance());

    @Override
    public String execute() {
        return souvenirService.findAll().toString();
    }
}
