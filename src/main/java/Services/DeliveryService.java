package Services;

import Models.Delivery;
import Repository.DeliveryRepository;

import java.util.List;

public class DeliveryService extends Service<Delivery>{

    public DeliveryService(){
        super(new DeliveryRepository(Delivery.class));
    }
    public List<Delivery> searchByDeliveryDate(String keyword) {
        return ((DeliveryRepository) repository).searchByDeliveryDate(keyword);
    }

    public List<Delivery> searchByDeliveryTime(String keyword) {
        return ((DeliveryRepository) repository).searchByDeliveryTime(keyword);
    }

    public List<Delivery> searchByDeliveryAddress(String keyword) {
        return ((DeliveryRepository) repository).searchByDeliveryAddress(keyword);
    }

    public List<Delivery> searchByFullNameClient(String keyword) {
        return ((DeliveryRepository) repository).searchByFullNameClient(keyword);
    }

    public List<Delivery> searchByFullNameCourier(String keyword) {
        return ((DeliveryRepository) repository).searchByFullNameCourier(keyword);
    }
}
