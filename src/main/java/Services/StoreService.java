package Services;

import Models.Store;
import Repository.StoreRepository;

import java.util.List;

public class StoreService extends Service<Store>{

    public StoreService(){
        super(new StoreRepository(Store.class));
    }
    public List<Store> searchByEmail(String keyword) {
        return ((StoreRepository) repository).searchByEmail(keyword);
    }

    public List<Store> searchByDeliveryPayment(String keyword) {
        return ((StoreRepository) repository).searchByDeliveryPayment(keyword);
    }


}