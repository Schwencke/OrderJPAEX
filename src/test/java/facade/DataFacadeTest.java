package facade;

import entitys.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataFacadeTest {
    DataFacade df;

    @BeforeEach
    void setUp() {
        df = new DataFacade();
        Customer q1 = new Customer("Thomas", "Thomasovergaard@hotmail.com");
        javax.persistence.EntityManager em = facade.EntityManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(q1);
        em.getTransaction().commit();
    }

    @Test
    public void getCustomer() {
        int customerId = 1;
        String actual = "";
        String expected = "Thomas";
        actual = df.getCustomer(customerId).getName();
        assertEquals(actual, expected);
    }
}