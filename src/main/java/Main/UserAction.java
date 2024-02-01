package Main;

import Models.Product;
import Models.Store;
import Services.DeliveryService;
import Services.OrderService;
import Services.ProductService;
import Services.StoreService;

import java.util.List;

public class UserAction {

    private final DeliveryService deliveryService;
    private final OrderService orderService;
    private final StoreService storeService;
    private final ProductService productService;

    public UserAction(){
        this.deliveryService = new DeliveryService();
        this.orderService = new OrderService();
        this.storeService = new StoreService();
        this.productService = new ProductService();

    }

    private void printStores(List<Store> stores){
        System.out.println("Stores: " + '\n');
        for(Store store: stores){
            System.out.println(store.toString());
        }
        System.out.println("_____________________________________");
    }

    public void findAllStores(){
        //System.out.println("fff");
        List<Store> stores = storeService.findAll();
        printStores(stores);
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
