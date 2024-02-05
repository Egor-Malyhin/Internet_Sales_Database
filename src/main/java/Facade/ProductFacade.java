package Facade;

import Models.Product;
import Services.ProductService;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ProductFacade extends Facade<Product>{

    public ProductFacade(ProductService productService, Scanner scanner) {
        super(scanner, productService);
    }

    private void printProduct(List<Product> products) {
        System.out.println("Products: " + '\n');
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("_________________________________________________________________________________________________");
    }

    private Product constructProduct() {
        try {

            System.out.println("Add new Product data:");

            int id = readIdFromConsole();

            Product productToInsert = service.findById(id);
            if (productToInsert != null)
                return null;

            System.out.print("Product name: ");
            String name = scanner.nextLine();

            System.out.print("Product model: ");
            String model = scanner.nextLine();

            System.out.print("Technical Characterisation: ");
            String tech_char = scanner.nextLine();

            System.out.print("Price: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Guarantee period: ");
            int guarantee = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Image (Specify the path to the image)(C:\\path\\to\\your\\image.jpg): ");
            String pathToImage = scanner.nextLine();
            while(ImageIO.read(new File(pathToImage))==null){
                System.out.println("Wrong path, try again");
            }
            byte[] image = Files.readAllBytes(Paths.get(pathToImage));
            return new Product(id, name, model, tech_char, price, guarantee, image);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Product constructProductToUpdate() {
        try {
            int id = readIdFromConsole();

            Product productToUpdate = service.findById(id);
            if (productToUpdate == null)
                return null;

            System.out.print("Product name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty())
                productToUpdate.setName(name);

            System.out.print("Product model: ");
            String model = scanner.nextLine();
            if (!model.isEmpty())
                productToUpdate.setModel(model);

            System.out.print("Technical characterisation: ");
            String tech_char = scanner.nextLine();
            if (!tech_char.isEmpty())
                productToUpdate.setTechChar(tech_char);

            System.out.print("Price: ");
            String price = scanner.nextLine();
            if (!price.isEmpty()) {
                int price_ = Integer.parseInt(price);
                productToUpdate.setPrice(price_);
            }

            System.out.print("Guarantee period: ");
            String guarantee = scanner.nextLine();
            if (!guarantee.isEmpty()) {
                int guarantee_ = Integer.parseInt(price);
                productToUpdate.setGuarantee(guarantee_);
            }

            System.out.print("Image (Specify the path to the image)(C:\\path\\to\\your\\image.jpg): ");

            String pathToImage = scanner.nextLine();
            if (!pathToImage.isEmpty()) {
                while (ImageIO.read(new File(pathToImage)) == null) {
                    System.out.println("Wrong path, try again");
                }
                byte[] image = Files.readAllBytes(Paths.get(pathToImage));
                productToUpdate.setImage(image);
            }
            return productToUpdate;

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findById() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Product product = service.findById(id);

        if (product == null)
            System.out.println("Product with such id not found.");
        else {
            System.out.println(product.toString());
        }
    }

    @Override
    public void findAllData() {
        List<Product> products = service.findAll();
        printProduct(products);
    }

    @Override
    public void findDataByCondition() {

        System.out.println("Choose search criteria:");
        System.out.println("1. By Product Name");
        System.out.println("2. By Product model");
        System.out.println("3. By Technical Characterisation");
        System.out.println("4. By Price");
        System.out.println("5. By Guarantee period");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Product> searchResult = null;

        switch (choice) {
            case 1:
                System.out.print("Product name: ");
                String name = scanner.nextLine();
                searchResult = ((ProductService) service).searchByName(name);
                break;

            case 2:
                System.out.print("Product model: ");
                String model = scanner.nextLine();
                searchResult = ((ProductService) service).searchByModel(model);
                break;

            case 3:
                System.out.print("Technical Characterisation: ");
                String tech_char = scanner.nextLine();
                searchResult = ((ProductService) service).searchByTechChar(tech_char);
                break;

            case 4:
                System.out.print("Price: ");
                int price = scanner.nextInt();
                scanner.nextLine();
                String _price = String.valueOf(price);
                searchResult = ((ProductService) service).searchByPrice(_price);
                break;

            case 5:
                System.out.print("Guarantee period: ");
                int guarantee = scanner.nextInt();
                scanner.nextLine();
                String _guarantee = String.valueOf(guarantee);
                searchResult = ((ProductService) service).searchByGuarantee(_guarantee);
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
        if (searchResult != null) {
            printProduct(searchResult);
        }
    }

    @Override
    public void saveToDatabase() {
        Product product = constructProduct();
        if (product == null) {
            System.out.println("Cannot Save by this Id.");
            return;
        }
        service.save(product);
        System.out.println("Product successfully saved.");
    }

    @Override
    public void updateInDatabase() {
        Product productToUpdate = constructProductToUpdate();
        if (productToUpdate == null) {
            System.out.println("Cannot update by this Id.");
            return;
        }
        service.update(productToUpdate);
        System.out.println("Delivery successfully update.");
    }

    @Override
    public void deleteFromDatabase() {
        int id = readIdFromConsole();
        scanner.nextLine();

        Product productToDelete = service.findById(id);

        if (productToDelete == null) {
            System.out.println("Product with such id not found.");
            return;
        }

        service.delete(productToDelete);
        System.out.println("Product deleted.");
    }
}
