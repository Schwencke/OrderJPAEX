import entitys.Customer;
import entitys.ItemType;
import entitys.Order;
import entitys.OrderLine;
import facade.DataFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static facade.EntityManager.getEntityManager;

public class Tester {


    public static void main(String[] args) {

        DataFacade dataFacade = new DataFacade();
        Customer q1 = new Customer("Thomas", "Thomasovergaard@hotmail.com");
        Customer q2 = new Customer("Palle Pop", "PillePopPalle@hotmail.com");
        ItemType it1 = new ItemType("Søm", "Søm er godt", 299);
        ItemType it2 = new ItemType("Skruer", "Skruer er sejere end søm", 399);
        OrderLine ol = new OrderLine(100);
        EntityManager em = getEntityManager();

        Order order = new Order();
        ol.setItemType(it1);
        order.addOrderLine(ol);
        order.setCustomer(q1);

        em.getTransaction().begin();
        em.persist(q1);
        em.getTransaction().commit();

        dataFacade.createCustomer(q2);
        dataFacade.createItemType(it1);
        dataFacade.createItemType(it2);


    }
}
