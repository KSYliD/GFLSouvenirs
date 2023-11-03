package org.example.command.read.producers;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;

import java.util.Scanner;

public class FindProducerBySouvenirOfSuchYearOperation implements MethodExecutor {
    private final ProducerService producerService =
            new ProducerServiceImpl(ProducerRepositoryImpl.getInstance(), SouvenirRepositoryImpl.getInstance());

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year ");
        int year = scanner.nextInt();
        return producerService.findBySouvenirInSuchYear(year).toString();
    }
}
