package dto;

public class OrderPriceDTO {

    private Integer price;
    private Integer quantity;
    private Integer orderId;
    private Integer customerId;
    private int id; //itemTypeID

    public OrderPriceDTO(Integer price, Integer quantity, Integer orderId, Integer customerId, int id) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.customerId = customerId;
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
