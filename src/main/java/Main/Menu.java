package Main;

import Facade.DeliveryFacade;
import Facade.OrderUserAction;
import Facade.ProductUserAction;
import Facade.StoreUserAction;
import Services.DeliveryService;
import Services.OrderService;
import Services.ProductService;
import Services.StoreService;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private final ProductUserAction productUserAction;
    private final OrderUserAction orderUserAction;
    private final DeliveryFacade deliveryUserAction;
    private final StoreUserAction storeUserAction;
    //private final UserAction userAction= new UserAction();
    private boolean exit;

    public Menu() {

        this.productUserAction = new ProductUserAction(new ProductService());
        this.orderUserAction = new OrderUserAction(new OrderService());
        this.deliveryUserAction = new DeliveryFacade(new DeliveryService());
        this.storeUserAction = new StoreUserAction(new StoreService());
        this.scanner = new Scanner(System.in);
        this.exit = false;
    }

    public void runMenu() {
        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    storeUserAction.findAllStores();
                    break;
                case 2:
                    productUserAction.findAllProducts();
                    System.out.println("Вы выбрали опцию 2");
                    break;
                case 3:
                    orderUserAction.findAllOrders();
                    System.out.println("Вы выбрали опцию 3");
                    break;
                case 4:
                    deliveryUserAction.findAllDelivery();
                    System.out.println("Вы выбрали опцию 4. Выход из программы.");
                    //exit = true;
                    break;
                case 5:
                    deliveryUserAction.saveDelivery();
                    break;
                case 6:
                    deliveryUserAction.updateDelivery();
                    break;
                case 7:
                    deliveryUserAction.deleteDelivery();
                    break;
                case 8:
                    deliveryUserAction.findDeliveryById();
                    break;
                case 9:
                    deliveryUserAction.findDeliveryByCondition();
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("===== Console Menu =====");
        System.out.println("1. View All Stores");
        System.out.println("2. Выполнить действие 2");
        System.out.println("3. Выполнить действие 3");
        System.out.println("4. Выйти из программы");
        System.out.println("5. Save Delivery into Database");
        System.out.println("6. Update Delivery in Database");
        System.out.println("7. Delete Delivery from Database");
        System.out.println("8. Find delivery by id");
        System.out.println("9. Find delivery by Condition");
        System.out.print("Выберите опцию: ");
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