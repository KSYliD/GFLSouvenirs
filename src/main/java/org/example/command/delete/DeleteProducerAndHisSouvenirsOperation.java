package org.example.command.delete;

import org.example.Main;
import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;

public class DeleteProducerAndHisSouvenirsOperation  implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());

    @Override
    public String execute() {
        producerService.deleteProducerAndHisSouvenirs(Main.producerInput());
        return  "The producer has been deleted successfully";
    }
}
