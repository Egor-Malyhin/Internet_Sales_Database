package Facade;

import Models.Store;
import Services.StoreService;

import java.util.List;
import java.util.Scanner;

public class StoreFacade extends Facade<Store> {

    public StoreFacade(StoreService storeService, Scanner scanner) {
        super(scanner, storeService);
    }

    private void printStore(List<Store> stores) {
        System.out.println("Stores: " + '\n');
        for (Store store : stores) {
            System.out.println(store.toString());
        }
        System.out.println("_________________________________________________________________________________________________");
    }

    private Store constructStore() {

        System.out.println("Add new delivery data:");

        int id = readIdFromConsole();

        Store storeToInsert = service.findById(id);
        if (storeToInsert != null)
            return null;

        System.out.print("Email address: ");
        String email = scanner.nextLine();

        System.out.print("Delivery payment: ");
        String payment = scanner.nextLine();
        boolean payment_ = Boolean.parseBoolean(payment);

        return new Store(id, email, payment_);
    }

    private Store constructStoreToUpdate() {

        int id = readIdFromConsole();
        scanner.nextLine();

        Store storeToUpdate = service.findById(id);
        if (storeToUpdate == null)
            return null;

        System.out.println("Update store data:");

        System.out.print("Email address: ");
        String email = scanner.nextLine();
        if (!email.isEmpty())
            storeToUpdate.setEmail(email);

        System.out.print("Delivery payment: ");
        String payment = scanner.nextLine();
        if (!payment.isEmpty()) {
            boolean payment_ = Boolean.parseBoolean(payment);
            storeToUpdate.setEmail(email);
        }

        return storeToUpdate;

    }

    @Override
    public void findById() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Store store = service.findById(id);

        if (store == null)
            System.out.println("Delivery with such id not found.");
        else {
            System.out.println(store.toString());
        }
    }

    @Override
    public void findAllData() {
        List<Store> stores = service.findAll();
        printStore(stores);
    }

    @Override
    public void findDataByCondition() {

        System.out.println("Choose search criteria:");
        System.out.println("1. By Store Email Address");
        System.out.println("2. By Store Delivery Payment");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Store> searchResult = null;

        switch (choice) {
            case 1:
                System.out.print("Email Address: ");
                String email = scanner.nextLine();
                searchResult = ((StoreService) service).searchByEmail(email);
                break;

            case 2:
                System.out.print("Delivery Payment: ");
                String payment = scanner.nextLine();
                searchResult = ((StoreService) service).searchByDeliveryPayment(payment);
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 2.");
        }
        if (searchResult != null) {
            printStore(searchResult);
        }
        else{
            System.out.println("Data not found");
        }
    }

    @Override
    public void saveToDatabase() {
        Store store = constructStore();
        if (store == null) {
            System.out.println("Cannot Save by this Id.");
            return;
        }
        service.save(store);
        System.out.println("Store successfully saved.");
    }

    @Override
    public void updateInDatabase() {
        Store storeToUpdate = constructStoreToUpdate();
        if (storeToUpdate == null) {
            System.out.println("Cannot update by this Id.");
            return;
        }
        service.update(storeToUpdate);
        System.out.println("Store successfully update.");
    }

    @Override
    public void deleteFromDatabase() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Store storeToDelete = service.findById(id);

        if (storeToDelete == null) {
            System.out.println("Delivery with such id not found.");
            return;
        }
        service.delete(storeToDelete);
        System.out.println("Delivery deleted.");
    }
}