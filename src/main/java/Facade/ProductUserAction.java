package Facade;

import Models.Product;
import Services.ProductService;

import java.util.List;

public class ProductUserAction {

    private final ProductService productService;

    public ProductUserAction(ProductService productService){
        this.productService = new ProductService();
    }

    private void printProducts(List<Product> products){
        System.out.println("Stores: " + '\n');
        for(Product product: products){
            System.out.println(product.toString());
        }
        System.out.println("_____________________________________");
    }

    public void findAllProducts(){
        System.out.println("fff");
        List<Product> products = productService.findAll();
        printProducts(products);
    }


}
