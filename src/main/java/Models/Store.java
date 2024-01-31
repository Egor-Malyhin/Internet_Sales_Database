package Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "stores")
public class Store {
    @Id
    @Column(name = "store_code")
    private int id;
    @Column(name = "email_address")
    private String email;
    @Column(name = "del_payment")
    private boolean payment;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Order> orders;
    public Store() {
    }
    public Store(int id, String email, boolean payment) {
        this.id = id;
        this.email = email;
        this.payment = payment;
        orders = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        order.setStore(this);
        orders.add(order);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public boolean getPayment() {
        return payment;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPayment(boolean payment){
        this.payment=payment;
    }
    public void setOrders(ArrayList<Order> orders){
        this.orders=orders;
    }
    @Override
    public String toString() {
        return "Models.Store{" +
                "store_code=" + id +
                ", email_address='" + email + '\'' +
                ", del_payment=" + payment +
                '}';
    }
}