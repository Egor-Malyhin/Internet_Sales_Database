package Models;

import javax.persistence.*;
@Entity
@Table (name = "orders")
public class Delivery {
    @Id
    @Column(name = "order_code")
    private int id;
    @OneToOne (mappedBy = "delivery")
    private Order order;
    @Column(name = "delivery_date")
    private String date;
    @Column(name = "delivery_time")
    private String time;
    @Column(name = "delivery_address")
    private String address;
    @Column(name = "full_name_client")
    private String client_name;
    @Column(name = "full_name_courier")
    private String courier_name;

    public Delivery() {
    }
    public Delivery(int id, String date, String time, String address, String client_name, String courier_name) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.address=address;
        this.client_name=client_name;
        this.courier_name=courier_name;
    }

    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getAddress() {return address;}
    public String getClientName() {
        return client_name;
    }
    public String getCourierName() {
        return courier_name;
    }

    public Order getOrder(){
        return order;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setClientName(String client_name) {
        this.client_name = client_name;
    }
    public void setCourierName(String client_name) {
        this.courier_name = courier_name;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "models.Delivery{" +
                "order_code=" + id +
                ", delivery_date='" + date + '\'' +
                ", delivery_time='" + time + '\'' +
                ", delivery_address='" + address + '\'' +
                ", full_name_client='" + client_name +'\'' +
                ", full_name_courier='" + courier_name +'\'' +
                '}';
    }
}