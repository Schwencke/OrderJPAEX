package entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @ManyToOne
    Customer customer;
    @OneToMany (mappedBy = "orders", cascade = CascadeType.PERSIST)
    List<OrderLine> orderLineList;


    public Orders() {
        orderLineList = new ArrayList<>();
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
        orderLineList = new ArrayList<>();

    }

    public void addOrderLine(OrderLine orderList){
        this.orderLineList.add(orderList);
        if (orderList != null){
            orderList.setOrder(this);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}