package entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "customer")
@Entity
@NamedQuery(name = "Customer.findCustomerById", query = "select c FROM Customer c WHERE c.id=:customerId")
@NamedQuery(name = "Customer.findAllCustomers", query = "select c FROM Customer c")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String email;
    @OneToMany (mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order){
        this.orderList.add(order);
        if(order != null ){
            order.setCustomer(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}