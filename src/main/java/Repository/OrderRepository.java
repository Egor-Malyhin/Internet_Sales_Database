package Repository;

import Models.Order;

import java.util.List;

public class OrderRepository extends Repository<Order> {
    public OrderRepository(Class<Order> entity){
        super(entity);
    }
    public List<Order> searchByOrderDate(String keyword) {
        return findByCell("order_date", keyword);
    }

    public List<Order> searchByModel(String keyword) {
        return findByCell("order_time", keyword);
    }

    public List<Order> searchByQuantity(String keyword) {
        return findByCell("quantity", keyword);
    }

    public List<Order> searchByFullNameClient(String keyword) {
        return findByCell("full_name_client", keyword);
    }

    public List<Order> searchByPhoneNumber(String keyword) {
        return findByCell("phone_number", keyword);
    }

    public List<Order> searchByOrderConfirmation(String keyword) {
        return findByCell("order_conf", keyword);
    }

}