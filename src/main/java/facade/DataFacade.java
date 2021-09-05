package facade;

import entitys.Customer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static facade.EntityManager.getEntityManager;

public class DataFacade {
    EntityManager em = getEntityManager();

    public void createCustomer(String name, String email) {
        Customer customer = new Customer(name, email);
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
//
//    public void createItemType() {
//
//
//    }
//
//    public ItemType findItemType() {
//        return null;
//    }
//
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
