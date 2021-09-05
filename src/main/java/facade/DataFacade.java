package facade;

import entitys.Customer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static facade.EntityManager.getEntityManager;

public class DataFacade {


    public void createCustomer() {

    }

    public Customer getCustomer(int customerId) {
        Query q = getEntityManager().createNamedQuery("Customer.findCustomerById");
        q.setParameter("customerId", customerId);
        return (Customer) q.getSingleResult();
    }

//    public Customer getAllCustomers() {
//        return null;
//    }
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
