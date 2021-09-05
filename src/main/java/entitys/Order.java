package entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "order")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @ManyToOne
    Customer customer;
    @OneToMany (mappedBy = "order", cascade = CascadeType.PERSIST)
    List<OrderLine> orderLineList;


    public Order() {
        this.customer = new Customer();
        orderLineList = new ArrayList<>();
    }

    public Order(Integer orderId) {
        this.orderId = orderId;
        this.customer = new Customer();
        orderLineList = new ArrayList<>();

    }

    public void addOrderLine(OrderLine orderList){
        this.orderLineList.add(orderList);
        if (orderList != null){
            orderList.getOrder().addOrderLine(orderList);

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