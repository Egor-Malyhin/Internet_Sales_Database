package Repository;

import Models.Store;

import java.util.List;

public class StoreRepository extends Repository<Store> {
    public StoreRepository(Class<Store> entity){
        super(entity);
    }
    public List<Store> searchByEmail(String keyword) {
        return findByCell("email_address", keyword);
    }

    public List<Store> searchByModel(String keyword) {
        return findByCell("model", keyword);
    }

    public List<Store> searchByDeliveryPayment(String keyword) {
        return findByCell("del_payment", keyword);
    }


}
