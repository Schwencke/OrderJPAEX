package entitys;

import javax.persistence.*;

@Table(name = "order_line")
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "itemtype_id")
    ItemType itemType;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    public OrderLine() {
    }

    public OrderLine(int quantity) {
        this.quantity = quantity;
        order = new Order();
        itemType = new ItemType();
    }

    public Order getOrder() {
        return order;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}