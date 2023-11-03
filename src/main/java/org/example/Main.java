package org.example;

import org.example.command.create.CreateProducerOperation;
import org.example.command.create.CreateSouvenirOperation;
import org.example.command.delete.DeleteProducerAndHisSouvenirsOperation;
import org.example.command.delete.DeleteSouvenirOperation;
import org.example.command.read.producers.FindAllProducersOperation;
import org.example.command.read.FindEverythingOperation;
import org.example.command.read.producers.FindProducerBySouvenirOfSuchYearOperation;
import org.example.command.read.producers.FindProducerBySouvenirsPriseLessThanOperation;
import org.example.command.read.souvenirs.FindAllSouvenirsOperation;
import org.example.command.read.souvenirs.FindSouvenirsByCountryOperation;
import org.example.command.read.souvenirs.FindSouvenirsByProducerOperation;
import org.example.command.read.souvenirs.FindSouvenirsByYearOperation;
import org.example.command.update.UpdateProducerOperation;
import org.example.command.update.UpdateSouvenirOperation;
import org.example.entities.Producer;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static Producer producerInput() {
        System.out.println("Enter id: ");
        long id = scanner.nextLong();
        System.out.println("Enter name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter country: ");
        String country = scanner.nextLine();
        return new Producer(id, name, country);
    }

    public static void getOperations() {
        System.out.println("Select an operation");
        System.out.println("1 Create the producer");
        System.out.println("2 Read all producers");
        System.out.println("3 Update producer");
        System.out.println("4 Find producers who has souvenir's prise less than ... ");
        System.out.println("5 Find producers who made souvenirs in such year");
        System.out.println("6 Delete producer and all his souvenirs");
        System.out.println("7 Create souvenir");
        System.out.println("8 Read all souvenirs");
        System.out.println("9 Find souvenirs by country");
        System.out.println("10 Find souvenirs by producer");
        System.out.println("11 Find souvenirs by year");
        System.out.println("12 Update the souvenir");
        System.out.println("13 Delete the souvenir");
        System.out.println("14 Read everything");
        System.out.println("15 Get operations");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        getOperations();
        while (true) {

            int operationNum = scanner.nextInt();
            scanner.nextLine();

            switch (operationNum) {
                case 1 -> System.out.println(new CreateProducerOperation().execute());
                case 2 -> System.out.println(new FindAllProducersOperation().execute());
                case 3 -> System.out.println(new UpdateProducerOperation().execute());
                case 4 -> System.out.println(new FindProducerBySouvenirsPriseLessThanOperation().execute());
                case 5 -> System.out.println(new FindProducerBySouvenirOfSuchYearOperation().execute());
                case 6 -> System.out.println(new DeleteProducerAndHisSouvenirsOperation().execute());
                case 7 -> System.out.println(new CreateSouvenirOperation().execute());
                case 8 -> System.out.println(new FindAllSouvenirsOperation().execute());
                case 9 -> System.out.println(new FindSouvenirsByCountryOperation().execute());
                case 10 -> System.out.println(new FindSouvenirsByProducerOperation().execute());
                case 11 -> System.out.println(new FindSouvenirsByYearOperation().execute());
                case 12 -> System.out.println(new UpdateSouvenirOperation().execute());
                case 13 -> System.out.println(new DeleteSouvenirOperation().execute());
                case 14 -> System.out.println(new FindEverythingOperation().execute());
                case 15 -> getOperations();
                case 0 -> System.exit(0);
                default -> System.out.println("Wrong value, please try again");
            }
        }


    }
}