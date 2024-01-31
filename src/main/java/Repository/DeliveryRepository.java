package Repository;

import Models.Delivery;

import java.util.List;

public class DeliveryRepository extends Repository<Delivery> {
    public DeliveryRepository(Class<Delivery> entity){
        super(entity);
    }
    public List<Delivery> searchByDeliveryDate(String keyword) {
        return findByCell("delivery_date", keyword);
    }

    public List<Delivery> searchByDeliveryTime(String keyword) {
        return findByCell("delivery_time", keyword);
    }

    public List<Delivery> searchByDeliveryAddress(String keyword) {
        return findByCell("delivery_address", keyword);
    }

    public List<Delivery> searchByFullNameClient(String keyword) {
        return findByCell("full_name_client", keyword);
    }

    public List<Delivery> searchByFullNameCourier(String keyword) {
        return findByCell("full_name_courier", keyword);
    }
}