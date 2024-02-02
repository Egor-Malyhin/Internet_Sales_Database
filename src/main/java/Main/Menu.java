package Main;

import Facade.*;
import Services.DeliveryService;
import Services.OrderService;
import Services.ProductService;
import Services.StoreService;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private final ProductFacade productFacade;
    private final OrderFacade orderFacade;
    private final DeliveryFacade deliveryFacade;
    private final StoreFacade storeFacade;
    //private final UserAction userAction= new UserAction();
    private boolean exit;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.productFacade = new ProductFacade(new ProductService(), new Scanner(System.in));
        this.orderFacade = new OrderFacade(new OrderService(), new Scanner(System.in));
        this.deliveryFacade = new DeliveryFacade(new DeliveryService(), new Scanner(System.in));
        this.storeFacade = new StoreFacade(new StoreService(), new Scanner(System.in));
        this.exit = false;
    }

    public void runMenu() {
        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    productFacade.findAllData();
                    break;
                case 2:
                    productFacade.findById();
                    break;
                case 3:
                    productFacade.findDataByCondition();
                    break;
                case 4:
                    productFacade.saveToDatabase();
                    break;
                case 5:
                    productFacade.updateInDatabase();
                    break;
                case 6:
                    productFacade.deleteFromDatabase();
                    break;
                case 7:
                    storeFacade.findAllData();
                    break;
                case 8:
                    storeFacade.findById();
                    break;
                case 9:
                    storeFacade.findDataByCondition();
                    break;
                case 10:
                    storeFacade.saveToDatabase();
                    break;
                case 11:
                    storeFacade.updateInDatabase();
                    break;
                case 12:
                    storeFacade.deleteFromDatabase();
                    break;
                case 13:
                    orderFacade.findAllData();
                    break;
                case 14:
                    orderFacade.findById();
                    break;
                case 15:
                    orderFacade.findDataByCondition();
                    break;
                case 16:
                    orderFacade.saveToDatabase();
                    break;
                case 17:
                    orderFacade.updateInDatabase();
                    break;
                case 18:
                    orderFacade.deleteFromDatabase();
                    break;
                case 19:
                    deliveryFacade.findAllData();
                    break;
                case 20:
                    deliveryFacade.findById();
                    break;
                case 21:
                    deliveryFacade.findDataByCondition();
                    break;
                case 22:
                    deliveryFacade.saveToDatabase();
                    break;
                case 23:
                    deliveryFacade.updateInDatabase();
                    break;
                case 24:
                    deliveryFacade.deleteFromDatabase();
                    break;
                case 0:
                    System.out.println("Programm Close.");
                    System.exit(0);

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("===== Console Menu =====");
        System.out.println("1. View All Products");
        System.out.println("2. Find Product By Id");
        System.out.println("3. Find Product By Condition");
        System.out.println("4. Save Product Into Database");
        System.out.println("5. Update Product In Database");
        System.out.println("6. Delete Product From Database");
        System.out.println("_______________________________");
        System.out.println("7. View All Stores");
        System.out.println("8. Find Store By Id");
        System.out.println("9. Find Store By Condition");
        System.out.println("10. Save Store Into Database");
        System.out.println("11. Update Store In Database");
        System.out.println("12. Delete Store From Database");
        System.out.println("______________________________");
        System.out.println("13. View All Orders");
        System.out.println("14. Find Order By Id");
        System.out.println("15. Find Order By Condition");
        System.out.println("16. Save Order Into Database");
        System.out.println("17. Update Order In Database");
        System.out.println("18. Delete Order From Database");
        System.out.println("______________________________");
        System.out.println("19. View All Delivery");
        System.out.println("20. Find Delivery By Id");
        System.out.println("21. Find Delivery By Condition");
        System.out.println("22. Save Delivery Into Database");
        System.out.println("23. Update Delivery In Database");
        System.out.println("24. Delete Delivery From Database");
        System.out.println("_________________________________");
        System.out.println("0. Exit From Programm");
        System.out.print("Choose Option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Некорректный ввод. Введите число: ");
            scanner.next(); // Очистить ввод
        }
        return scanner.nextInt();
    }

    // Дополнительные методы для управления меню, если необходимо
}