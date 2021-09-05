package facade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

    public static javax.persistence.EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        javax.persistence.EntityManager em = emf.createEntityManager();
        return em;
    }
}
