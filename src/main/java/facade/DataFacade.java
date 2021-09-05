package facade;

import dto.OrderPriceDTO;
import entitys.Customer;
import entitys.ItemType;
import entitys.OrderLine;
import entitys.Orders;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static facade.EntityManager.getEntityManager;

public class DataFacade {
    EntityManager em = getEntityManager();

    public void persist(Object o){
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void createCustomer(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

    }

    public Customer getCustomer(int customerId) {
        Query q = em.createNamedQuery("Customer.findCustomerById");
        q.setParameter("customerId", customerId);
        return (Customer) q.getSingleResult();
    }

    public List<Customer> getAllCustomers() {
        Query q = em.createNamedQuery("Customer.findAllCustomers");
        return (List<Customer>) q.getResultList();
    }

    public void createItemType(ItemType itemType) {persist(itemType);}

    public ItemType getItemType(int itemId) {
       Query q = em.createNamedQuery("ItemType.findAllItemTypesById");
       q.setParameter("itemId", itemId);
        return (ItemType) q.getSingleResult();
    }

    public void createOrderForCustomer(OrderLine ol, Customer co) {
        Orders orders = new Orders();
        orders.addOrderLine(ol);
        orders.setCustomer(co);
        persist(orders);
    }

    public OrderLine createOrderlineForOrder(ItemType it, int quantity) {
        OrderLine orderLine = new OrderLine();
        orderLine.setItemType(it);
        orderLine.setQuantity(quantity);
        return orderLine;
    }

    public Orders addOrderLineToOrder(Orders order, OrderLine ol){
        order.addOrderLine(ol);
        persist(order);
        return order;
    }

    public List<Orders> getAllOrdersById() {
        List<Orders> orders = new ArrayList<>();
        TypedQuery<Orders> query = getEntityManager().createQuery("select o FROM Orders o WHERE o.customer=:customer", Orders.class);
        orders = query.getResultList();
        return orders;
    }

    public int totalCostOfOrder(int orderId) {
        TypedQuery<OrderPriceDTO> query = getEntityManager().createQuery("select new dto.OrderPriceDTO(i.price,l.quantity,o.orderId,o.customer.id,l.id) FROM Orders o, ItemType i JOIN o.orderLineList l", dto.OrderPriceDTO.class);
      //"select new dto.OrderPriceDTO(l.quantity,o.orderId,o.customer.id,l.id) FROM Orders o INNER JOIN o.orderLineList l INNER JOIN ", dto.OrderPriceDTO.class);
        List<OrderPriceDTO> orderLineList = query.getResultList();
        AtomicReference<Integer> total = new AtomicReference<>(0);
        orderLineList.forEach(orderPriceDTO -> {
            int price = orderPriceDTO.getPrice();
            int qt = orderPriceDTO.getQuantity();
            total.updateAndGet(v -> v + price * qt);
        });
        return total.get();
    }

}
