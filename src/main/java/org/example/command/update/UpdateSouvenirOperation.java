package org.example.command.update;

import org.example.command.MethodExecutor;
import org.example.entities.Souvenir;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.SouvenirService;
import org.example.services.SouvenirServiceImpl;

import java.util.Scanner;

public class UpdateSouvenirOperation implements MethodExecutor {
    private final SouvenirService souvenirService =
            new SouvenirServiceImpl(SouvenirRepositoryImpl.getInstance(), ProducerRepositoryImpl.getInstance());

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the souvenir you'd like to change: ");
        long id = scanner.nextLong();
        System.out.println("Enter new name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter new producer ID: ");
        long producerId = scanner.nextLong();
        System.out.println("Enter new producer year: ");
        int year = scanner.nextInt();
        System.out.println("Enter new producer prise: ");
        int prise = scanner.nextInt();
        souvenirService.updateSouvenir(new Souvenir(id, name, producerId, year, prise));
         return  "The souvenir has been changed successfully";

    }
}
