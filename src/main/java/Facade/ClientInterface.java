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

    protected boolean boolValueValidation(String bool) throws Exception {
        if (!bool.equals("y") && !bool.equals("n")) {
            System.out.println("Wrong enter, try again");
            throw new Exception("Wrong enter");
        }
        else{
            if(bool.equals("y"))
                return true;
            else return false;
        }
    }
}
