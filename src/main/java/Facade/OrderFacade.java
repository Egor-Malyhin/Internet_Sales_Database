package Facade;

import Models.Order;
import Models.Product;
import Models.Store;
import Services.OrderService;
import Services.ProductService;
import Services.StoreService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderFacade extends Facade<Order>{

    public OrderFacade(OrderService orderService, Scanner scanner) {
        super(scanner, orderService);
    }

    private void printOrder(List<Order> orders) {
        System.out.println("Orders: " + '\n');
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.println("_________________________________________________________________________________________________");
    }

    private Order constructOrder() {
        try {
            System.out.println("Add new order data:");
            int id = readIdFromConsole();
            scanner.nextLine();

            Order orderToInsert = service.findById(id);
            if (orderToInsert != null)
                return null;

            System.out.print("Store Id: ");
            int storeId = scanner.nextInt();
            scanner.nextLine();

            Store storeToInsert = new StoreService().findById(storeId);
            if (storeToInsert == null)
                return null;

            System.out.print("Product Id: ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            Product productToInsert = new ProductService().findById(id);
            if (productToInsert == null)
                return null;


            System.out.print("Order date: ");
            String dateString = scanner.nextLine();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

            System.out.print("Order time: ");
            String timeString = scanner.nextLine();
            LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Client full name: ");
            String client_full_name = scanner.nextLine();

            System.out.print("Phone number: ");
            String number = scanner.nextLine();

            System.out.print("Order Confirmed(true or false): ");
            String conf = scanner.nextLine();
            boolean conf_ = Boolean.parseBoolean(conf);

            return new Order(id, storeToInsert, productToInsert, date, time, quantity, client_full_name, number, conf_);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Order constructOrderToUpdate() {
        try {
            int id = readIdFromConsole();
            scanner.nextLine();

            Order orderToUpdate = service.findById(id);
            if (orderToUpdate == null)
                return null;

            System.out.println("Update order data:");

            System.out.print("Order date: ");
            String dateString = scanner.nextLine();
            if (!dateString.isEmpty()) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                orderToUpdate.setDate(date);
            }

            System.out.print("Order time: ");
            String timeString = scanner.nextLine();
            if (!timeString.isEmpty()) {
                LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
                orderToUpdate.setTime(time);
            }

            System.out.print("Quantity: ");
            String quantity = scanner.nextLine();
            if (!quantity.isEmpty()) {
                int quantity_ = Integer.parseInt(quantity);
                orderToUpdate.setQuantity(quantity_);
            }

            System.out.print("Client full name: ");
            String client_full_name = scanner.nextLine();
            if (!client_full_name.isEmpty())
                orderToUpdate.setClientName(client_full_name);

            System.out.print("Phone number: ");
            String number = scanner.nextLine();
            if (!number.isEmpty())
                orderToUpdate.setNumber(number);

            System.out.print("Order Confirmed(true or false): ");
            String conf = scanner.nextLine();
            if (!conf.isEmpty()) {
                boolean conf_ = Boolean.parseBoolean(conf);
                orderToUpdate.setConf(conf_);
            }
            return orderToUpdate;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void findById() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Order order = service.findById(id);

        if (order == null)
            System.out.println("Order with such id not found.");
        else {
            System.out.println(order.toString());
        }
    }

    @Override
    public void findAllData() {
        List<Order> orders = service.findAll();
        printOrder(orders);
    }

    @Override
    public void findDataByCondition() {

        System.out.println("Choose search criteria:");
        System.out.println("1. By Order Date");
        System.out.println("2. By Order Time");
        System.out.println("3. By Quantity");
        System.out.println("4. By Client Full Name");
        System.out.println("5. By Phone Number");
        System.out.println("6. By Order Confirmation");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Order> searchResult = null;

        switch (choice) {
            case 1:
                System.out.print("Order Date: ");
                String date = scanner.nextLine();
                searchResult = ((OrderService) service).searchByOrderDate(date);
                break;

            case 2:
                System.out.print("Order Time: ");
                String time = scanner.nextLine();
                searchResult = ((OrderService) service).searchByOrderTime(time);
                break;

            case 3:
                System.out.print("Quantity: ");
                String address = scanner.nextLine();
                searchResult = ((OrderService) service).searchByQuantity(address);
                break;

            case 4:
                System.out.print("Client Full Name: ");
                String client = scanner.nextLine();
                searchResult = ((OrderService) service).searchByFullNameClient(client);
                break;

            case 5:
                System.out.print("Phone Number: ");
                String number = scanner.nextLine();
                searchResult = ((OrderService) service).searchByPhoneNumber(number);
                break;

            case 6:
                System.out.print("Order Confirmation: ");
                String conf = scanner.nextLine();
                searchResult = ((OrderService) service).searchByOrderConfirmation(conf);
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }
        if (searchResult != null) {
            printOrder(searchResult);
        }
    }

    @Override
    public void saveToDatabase() {
        Order order = constructOrder();
        if (order == null) {
            System.out.println("Cannot Save by this Id.");
            return;
        }
        service.save(order);
        System.out.println("Delivery successfully saved.");
    }

    @Override
    public void updateInDatabase() {
       Order orderToUpdate = constructOrderToUpdate();
        if (orderToUpdate == null) {
            System.out.println("Cannot update by this Id.");
            return;
        }
        service.update(orderToUpdate);
        System.out.println("Order successfully update.");
    }

    @Override
    public void deleteFromDatabase() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Order orderToDelete = service.findById(id);

        if (orderToDelete == null) {
            System.out.println("Order with such id not found.");
            return;
        }
        service.delete(orderToDelete);
        System.out.println("Order deleted.");
    }
}
