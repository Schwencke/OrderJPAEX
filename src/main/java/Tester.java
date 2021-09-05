import entitys.Customer;
import entitys.ItemType;
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
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(q1);
        em.getTransaction().commit();

        System.out.println(dataFacade.getCustomer(1).getName());

        dataFacade.createCustomer(q2);

        List<Customer> customerList = dataFacade.getAllCustomers();

        customerList.forEach(customer -> {
            System.out.println(customer.getName());
        });

        dataFacade.createItemType(it1);
        dataFacade.createItemType(it2);

        ItemType itemType = dataFacade.getItemType(1);
        System.out.println(itemType.getName());
        System.out.println(itemType.getDescription());
        System.out.println(itemType.getPrice());

    }
}
