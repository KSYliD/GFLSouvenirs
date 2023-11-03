package org.example;


import org.example.entities.Producer;
import org.example.entities.Souvenir;
import org.example.repositories.ProducerRepositoryImpl;
import org.example.repositories.SouvenirRepositoryImpl;
import org.example.services.ProducerService;
import org.example.services.ProducerServiceImpl;
import org.example.services.SouvenirService;
import org.example.services.SouvenirServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProducerService producerService =
                new ProducerServiceImpl(new ProducerRepositoryImpl(), new SouvenirRepositoryImpl());
        SouvenirService souvenirService =
                new SouvenirServiceImpl(new SouvenirRepositoryImpl(), new ProducerRepositoryImpl());

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
        System.out.println("0. Exit");

        while (true) {

            int operationNum = scanner.nextInt();
            scanner.nextLine();

            switch (operationNum) {
                case 1 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    System.out.println("Enter name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println("Enter country: ");
                    String country = scanner.nextLine();
                    producerService.createProducer(new Producer(id, name, country));
                    System.out.println(name + " has been created successfully, your ID is " + id);
                }
                case 2 -> System.out.println(producerService.readAll().stream().map(Producer::toString).toList());
                case 3 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    System.out.println("Enter name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println("Enter country: ");
                    String country = scanner.nextLine();
                    producerService.updateProducer(new Producer(id, name, country));
                    System.out.println("The producer has been changed successfully");
                }
                case 4 -> {
                    System.out.println("Enter the prise ");
                    int prise = scanner.nextInt();
                    System.out.println(producerService.findByPriseLessThan(prise));
                }
                case 5 -> {
                    System.out.println("Enter year ");
                    int year = scanner.nextInt();
                    producerService.findByPriseLessThan(year);
                }
                case 6 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    System.out.println("Enter name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println("Enter country: ");
                    String country = scanner.nextLine();
                    producerService.deleteProducerAndHisSouvenirs(new Producer(id, name, country));
                    System.out.println("The producer has been deleted successfully");
                }
                case 7 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    System.out.println("Enter name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println("Enter producer ID: ");
                    long producerId = scanner.nextLong();
                    System.out.println("Enter producer year: ");
                    int year = scanner.nextInt();
                    System.out.println("Enter producer prise: ");
                    int prise = scanner.nextInt();
                    souvenirService.createSouvenir(new Souvenir(id, name, producerId, year, prise));
                    System.out.println("The souvenir has been created successfully");
                }
                case 8 -> System.out.println(souvenirService.readAll().stream().map(s -> s.toString() + '\n').toList());
                case 9 -> {
                    System.out.println("Enter the country: ");
                    String country = scanner.nextLine();
                    System.out.println(souvenirService.findByCountry(country));
                }
                case 10 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    System.out.println("Enter name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println("Enter country: ");
                    String country = scanner.nextLine();
                    System.out.println(souvenirService.findByProducer(new Producer(id, name, country)));
                }
                case 11 -> {
                    System.out.println("Enter the year");
                    int year = scanner.nextInt();
                    System.out.println(souvenirService.findByYear(year));
                }
                case 12 -> {
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
                    System.out.println("The souvenir has been changed successfully");
                }
                case 13 -> {
                    System.out.println("Enter id: ");
                    long id = scanner.nextLong();
                    souvenirService.deleteSouvenir(new Souvenir(id));
                    System.out.println("The souvenir has been deleted successfully");
                }
                case 14 -> System.out.println(producerService.readEverything());
                case 0 -> System.exit(0);
                default -> System.out.println("Wrong value, please try again");
            }
        }


    }
}