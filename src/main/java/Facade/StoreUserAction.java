package Facade;

import Models.Store;
import Services.StoreService;

import java.util.List;

public class StoreUserAction {
    private final StoreService storeService;

    public StoreUserAction(StoreService storeService){
        this.storeService = new StoreService();
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
}
