package org.example.command.read.souvenirs;

import org.example.command.MethodExecutor;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.SouvenirService;
import org.example.services.SouvenirServiceImpl;

import java.util.Scanner;

public class FindSouvenirsByYearOperation implements MethodExecutor {
    private final SouvenirService souvenirService =
            new SouvenirServiceImpl(SouvenirRepositoryImpl.getInstance(), ProducerRepositoryImpl.getInstance());

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the year");
        int year = scanner.nextInt();
        return souvenirService.findByYear(year).toString();
    }
}
