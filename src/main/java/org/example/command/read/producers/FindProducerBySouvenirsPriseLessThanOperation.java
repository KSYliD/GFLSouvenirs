package org.example.command.read.producers;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;

import java.util.Scanner;

public class FindProducerBySouvenirsPriseLessThanOperation implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the prise ");
        int prise = scanner.nextInt();
        return producerService.findByPriseLessThan(prise).toString();
    }
}
