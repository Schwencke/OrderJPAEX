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
    Orders orders;

    public OrderLine() {
    }

    public OrderLine(int quantity) {
        this.quantity = quantity;
        orders = new Orders();
        itemType = new ItemType();
    }

    public Orders getOrder() {
        return orders;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
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