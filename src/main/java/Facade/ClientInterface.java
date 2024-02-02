package Facade;

import Services.ServiceCRUDInterface;

import java.util.Scanner;

public interface ClientInterface {
    public void findById();
    public void findAllData();
    public void findDataByCondition();
    public void saveToDatabase();
    public void updateInDatabase();
    public void deleteFromDatabase();
}

abstract class Facade<T> implements ClientInterface{

    protected final Scanner scanner;
    protected final ServiceCRUDInterface<T> service;
    Facade(Scanner scanner, ServiceCRUDInterface<T> service){
        this.scanner = scanner;
        this.service = service;
    }

    protected int readIdFromConsole() {
        System.out.print("Enter id: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please, enter integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
