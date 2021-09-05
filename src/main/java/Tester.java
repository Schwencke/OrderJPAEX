import entitys.Customer;
import entitys.ItemType;
import entitys.Orders;
import entitys.OrderLine;
import facade.DataFacade;

import javax.persistence.EntityManager;

import static facade.EntityManager.getEntityManager;

public class Tester {


    public static void main(String[] args) {

        DataFacade dataFacade = new DataFacade();
        Customer q1 = new Customer("Thomas", "Thomasovergaard@hotmail.com");
        Customer q2 = new Customer("Palle Pop", "PillePopPalle@hotmail.com");
        ItemType it1 = new ItemType("Søm", "Søm er godt", 299);
        ItemType it2 = new ItemType("Skruer", "Skruer er sejere end søm", 399);
        OrderLine ol = new OrderLine(5);
        OrderLine ol2 = new OrderLine(1);
        EntityManager em = getEntityManager();

        dataFacade.createCustomer(q2);
        dataFacade.createItemType(it1);
        dataFacade.createItemType(it2);

        Orders orders = new Orders();
        ol.setItemType(it1);
        ol2.setItemType(it2);
        orders.addOrderLine(ol);
        orders.addOrderLine(ol2);
        orders.setCustomer(q1);

        dataFacade.createCustomer(q2);
        dataFacade.createItemType(it1);
        dataFacade.createItemType(it2);

        em.getTransaction().begin();
        em.persist(q1);
        em.persist(orders);
        em.getTransaction().commit();

        System.out.println("Total pris for orderID: 1" + dataFacade.totalCostOfOrder(1));


    }
}
