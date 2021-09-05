import entitys.Customer;
import facade.DataFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {


    public static void main(String[] args) {

        DataFacade dataFacade = new DataFacade();
        Customer q1 = new Customer("Thomas", "Thomasovergaard@hotmail.com");
        EntityManager em = facade.EntityManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(q1);
        em.getTransaction().commit();

        System.out.println(dataFacade.getCustomer(1).getName());
    }
}
