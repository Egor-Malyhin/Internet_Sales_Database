package Facade;

import Models.Delivery;
import Models.Order;
import Services.DeliveryService;
import Services.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DeliveryFacade extends Facade<Delivery>{

    public DeliveryFacade(DeliveryService deliveryService, Scanner scanner) {
        super(scanner, deliveryService);
    }

    private void printDelivery(List<Delivery> deliverys) {
        System.out.println("Delivery: " + '\n');
        for (Delivery delivery : deliverys) {
            System.out.println(delivery.toString());
        }
        System.out.println("_________________________________________________________________________________________________");
    }

    private Delivery constructDelivery() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Add new delivery data:");

            System.out.print("Order Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Delivery deliveryToInsert = service.findById(id);
            if (deliveryToInsert != null)
                return null;

            Order order = new OrderService().findById(id);
            if (order == null)
                return null;

            System.out.print("Delivery date: ");
            String dateString = scanner.nextLine();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);


            System.out.print("Delivery time: ");
            String timeString = scanner.nextLine();
            LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));


            System.out.print("Delivery address: ");
            String address = scanner.nextLine();

            System.out.print("Client full name: ");
            String client_full_name = scanner.nextLine();

            System.out.print("Courier full name: ");
            String courier_full_name = scanner.nextLine();
            return new Delivery(id, date, time, address, client_full_name, courier_full_name);


        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Delivery constructDeliverytoUpdate() {
        try {
            int id = readIdFromConsole();
            scanner.nextLine();

            Delivery deliveryToUpdate = service.findById(id);
            if (deliveryToUpdate == null)
                return null;

            System.out.println("Update student data:");

            System.out.print("Delivery date: ");
            String dateString = scanner.nextLine();
            if (!dateString.isEmpty()) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                deliveryToUpdate.setDate(date);
            }

            System.out.print("Delivery time: ");
            String timeString = scanner.nextLine();
            if (!timeString.isEmpty()) {
                LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
                deliveryToUpdate.setTime(time);
            }

            System.out.print("Delivery address: ");
            String address = scanner.nextLine();
            if (!address.isEmpty())
                deliveryToUpdate.setAddress(address);

            System.out.print("Client full name: ");
            String client_full_name = scanner.nextLine();
            if (!client_full_name.isEmpty())
                deliveryToUpdate.setClientName(client_full_name);

            System.out.print("Courier full name: ");
            String courier_full_name = scanner.nextLine();
            if (!courier_full_name.isEmpty())
                deliveryToUpdate.setCourierName(courier_full_name);

            return deliveryToUpdate;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void findById() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Delivery delivery = service.findById(id);

        if (delivery == null)
            System.out.println("Delivery with such id not found.");
        else {
            System.out.println(delivery.toString());
        }
    }

    @Override
    public void findAllData() {
        List<Delivery> deliverys = service.findAll();
        printDelivery(deliverys);
    }

    @Override
    public void findDataByCondition() {

        System.out.println("Choose search criteria:");
        System.out.println("1. By Delivery Date");
        System.out.println("2. By Delivery Time");
        System.out.println("3. By Delivery Address");
        System.out.println("4. By Client Full Name");
        System.out.println("5. By Courier Full Name");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Delivery> searchResult = null;

        switch (choice) {
            case 1:
                System.out.print("Delivery Date: ");
                String date = scanner.nextLine();
                searchResult = ((DeliveryService) service).searchByDeliveryDate(date);
                break;

            case 2:
                System.out.print("Delivery Time: ");
                String time = scanner.nextLine();
                searchResult = ((DeliveryService) service).searchByDeliveryTime(time);
                break;

            case 3:
                System.out.print("Delivery Address: ");
                String address = scanner.nextLine();
                searchResult = ((DeliveryService) service).searchByDeliveryAddress(address);
                break;

            case 4:
                System.out.print("Client Full Name: ");
                String client = scanner.nextLine();
                searchResult = ((DeliveryService) service).searchByFullNameClient(client);
                break;

            case 5:
                System.out.print("Courier Full Name: ");
                String courier = scanner.nextLine();
                searchResult = ((DeliveryService) service).searchByFullNameCourier(courier);
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
        if (searchResult != null) {
            printDelivery(searchResult);
        }
    }

    @Override
    public void saveToDatabase() {
        Delivery delivery = constructDelivery();
        if (delivery == null) {
            System.out.println("Cannot Save by this Id.");
            return;
        }
        service.save(delivery);
        System.out.println("Delivery successfully saved.");
    }

    @Override
    public void updateInDatabase() {
        Delivery deliveryToUpdate = constructDeliverytoUpdate();
        if (deliveryToUpdate == null) {
            System.out.println("Cannot update by this Id.");
            return;
        }
        service.update(deliveryToUpdate);
        System.out.println("Delivery successfully update.");
    }

    @Override
    public void deleteFromDatabase() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Delivery deliveryToDelete = service.findById(id);

        if (deliveryToDelete == null) {
            System.out.println("Delivery with such id not found.");
            return;
        }
        service.delete(deliveryToDelete);
        System.out.println("Delivery deleted.");
    }
}
