package Facade;

import Models.Order;
import Services.OrderService;

import java.util.List;

public class OrderUserAction {
    private final OrderService orderService;

    public OrderUserAction (OrderService orderService){
        this.orderService = new OrderService();
    }

    private void printOrders(List<Order> orders){
        System.out.println("Orders: " + '\n');
        for(Order order: orders){
            System.out.println(order.toString());
        }
        System.out.println("_____________________________________");
    }

    public void findAllOrders(){
        System.out.println("fff");
        List<Order> orders = orderService.findAll();
        printOrders(orders);
    }


}
