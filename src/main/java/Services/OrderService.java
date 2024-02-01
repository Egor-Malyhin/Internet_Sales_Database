package Services;

import Models.Order;
import Repository.OrderRepository;

import java.util.List;

public class OrderService extends Service<Order>{

    public OrderService(){
        super(new OrderRepository(Order.class));
    }
    public List<Order> searchByOrderDate(String keyword) {
        return ((OrderRepository) repository).searchByOrderDate(keyword);
    }

    public List<Order> searchByOrderTime(String keyword) {
        return ((OrderRepository) repository).searchByOrderTime(keyword);
    }

    public List<Order> searchByQuantity(String keyword) {
        return ((OrderRepository) repository).searchByQuantity(keyword);
    }

    public List<Order> searchByFullNameClient(String keyword) {
        return ((OrderRepository) repository).searchByFullNameClient(keyword);
    }

    public List<Order> searchByPhoneNumber(String keyword) {
        return ((OrderRepository) repository).searchByPhoneNumber(keyword);
    }

    public List<Order> searchByOrderConfirmation(String keyword) {
        return ((OrderRepository) repository).searchByOrderConfirmation(keyword);
    }


}