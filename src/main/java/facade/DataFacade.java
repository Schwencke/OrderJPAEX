package facade;

import entitys.Customer;
import entitys.ItemType;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static facade.EntityManager.getEntityManager;

public class DataFacade {
    EntityManager em = getEntityManager();

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

    public void createItemType(ItemType itemType) {
    em.getTransaction().begin();
    em.persist(itemType);
    em.getTransaction().commit();

    }

    public ItemType getItemType(int itemId) {
       Query q = em.createNamedQuery("ItemType.findAllItemTypesById");
       q.setParameter("itemId", itemId);
        return (ItemType) q.getSingleResult();
    }

//    public void createOrderForCustomer() {
//
//    }
//
//    public OrderLine createOrderlineForOrder() {
//        return null;
//    }
//
//    public Order getAllOrders() {
//        return null;
//    }
//
//    public int totalCostOfOrder() {
//        return null;
//    }


}
