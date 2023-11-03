package org.example.command.delete;

import org.example.command.MethodExecutor;
import org.example.entities.Souvenir;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.SouvenirService;
import org.example.services.SouvenirServiceImpl;

import java.util.Scanner;

public class DeleteSouvenirOperation implements MethodExecutor {
    private final SouvenirService souvenirService =
            new SouvenirServiceImpl(SouvenirRepositoryImpl.getInstance(), ProducerRepositoryImpl.getInstance());

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        long id = scanner.nextLong();
        souvenirService.deleteSouvenir(new Souvenir(id));
        return  "The souvenir has been deleted successfully";

    }
}
