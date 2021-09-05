package entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "item_type")
@Entity
@NamedQuery(name = "ItemType.findAllItemTypesById", query = "SELECT i FROM ItemType i where i.id=:itemId")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String description;
    private int price;
    @OneToMany (mappedBy = "itemType", cascade = CascadeType.PERSIST)
    List<OrderLine> orderLineList;


    public ItemType() {
    }

    public ItemType(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        orderLineList = new ArrayList<>();
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void addOrderLine(OrderLine orderLine) {
        this.orderLineList.add(orderLine);
        if(orderLine != null){
            orderLine.setItemType(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}