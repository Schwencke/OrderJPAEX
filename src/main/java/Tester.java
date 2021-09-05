import entitys.Customer;
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
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(q1);
        em.getTransaction().commit();

        dataFacade.createCustomer("Palle Pop","PillePopPalle@hotmail.com");

        System.out.println(dataFacade.getCustomer(1).getName());
        System.out.println(dataFacade.getCustomer(2).getName());
        List<Customer> customerList = dataFacade.getAllCustomers();
        customerList.forEach(customer -> {
            System.out.println(customer.getName());
        });
    }
}
