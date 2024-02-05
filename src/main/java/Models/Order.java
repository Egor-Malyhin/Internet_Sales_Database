package Models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table (name = "orders")
public class Order {
    @Id
    @Column(name = "order_code")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY) //
    @JoinColumn(name = "store_code")
    private Store store;
    @ManyToOne(fetch = FetchType.LAZY) //
    @JoinColumn(name = "product_code")
    private Product product;
    @OneToOne (mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Delivery delivery;
    @Column(name = "order_date")
    private Date date;
    @Column(name = "order_time")
    private LocalTime time;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "full_name_client")
    private String client_name;
    @Column(name = "phone_number")
    private String number;
    @Column(name = "order_conf")
    private boolean conf;


    public Order() {
    }
    public Order(int id, Store store, Product product, Date date, LocalTime time, int quantity, String client_name, String number, boolean conf) {
        this.id = id;
        this.store=store;
        this.product=product;
        this.date = date;
        this.time=time;
        this.quantity=quantity;
        this.client_name=client_name;
        this.number=number;
        this.conf=conf;
    }

    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public int getQuantity() {return quantity;}
    public String getClientName() {
        return client_name;
    }
    public String getNumber() {
        return number;
    }
    public boolean getConf() {
        return conf;
    }
    public Store getStore(){
        return store;
    }
    public Product getProduct(){
        return product;
    }
    public Delivery getDelivery(){
        return delivery;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setClientName(String client_name) {
        this.client_name = client_name;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setConf(boolean conf) {
        this.conf = conf;
    }
    public void setProduct(Product product){
        this.product=product;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public void setDelivery(Delivery delivery){
        this.delivery=delivery;
    }

    @Override
    public String toString() {
        return "models.Order{" +
                "order_code=" + id +
                ", store_code=" + store.getId() +
                ", product_code=" + product.getId() +
                ", order_date='" + date + '\'' +
                ", order_time='" + time + '\'' +
                ", quantity=" + quantity +
                ", full_name_client='" + client_name +'\'' +
                ", phone_number='" + number +'\'' +
                ", order_conf=" + conf +
                '}';
    }
}