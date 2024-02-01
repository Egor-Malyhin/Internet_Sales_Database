package Main;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private UserAction userAction= new UserAction();
    private boolean exit;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.exit = false;
    }

    public void runMenu() {
        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    userAction.findAllStores();
                    break;
                case 2:
                    System.out.println("Вы выбрали опцию 2");
                    break;
                case 3:
                    System.out.println("Вы выбрали опцию 3");
                    break;
                case 4:
                    System.out.println("Вы выбрали опцию 4. Выход из программы.");
                    exit = true;
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