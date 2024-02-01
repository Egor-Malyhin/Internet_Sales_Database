package Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "products")
public class Product {
    @Id
    @Column(name = "product_code")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "tech_char")
    private String tech_char;
    @Column(name = "price")
    private int price;
    @Column(name = "guarantee_period")
    private int guarantee;
    @Lob
    @Column(name = "image", columnDefinition = "bytea")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Order> orders;
    public Product() {
    }
    public Product(int id, String name, String model, String tech_char, int price, int guarantee, byte[] image) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.tech_char = tech_char;
        this.price = price;
        this.guarantee = guarantee;
        this.image = image;
        orders = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        order.setProduct(this);
        orders.add(order);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public String getTechChar() {
        return tech_char;
    }
    public int getPrice() {
        return price;
    }
    public int getGuarantee() {
        return guarantee;
    }

    public byte[] getImage() {
        return image;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setTechChar(String tech_char){
        this.tech_char=tech_char;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setGuarantee(int guarantee){
        this.guarantee=guarantee;
    }
    public void setImage(byte[] image){
        this.image=image;
    }
    public void setOrders(ArrayList<Order> orders){
        this.orders=orders;
    }

    @Override
    public String toString() {
        return "Models.Product{" +
                "product_code=" + id +
                ", product_name='" + name + '\'' +
                ", model='" + model +'\'' +
                ", tech_char='" + tech_char +'\'' +
                ", price=" + price +
                ", guarantee_period=" + guarantee +
                ", image= E'\\x" + image.toString() + '\'' +
                '}';
    }
}