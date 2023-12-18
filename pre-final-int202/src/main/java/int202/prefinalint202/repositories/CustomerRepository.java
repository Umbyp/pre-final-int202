package int202.prefinalint202.repositories;

import int202.prefinalint202.entities.Customer;
import int202.prefinalint202.utilities.EntityManagerBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Customer findByUserName(String accountName) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USERNAME");
        query.setParameter("userName", accountName);
        Customer customer = null;
        try {
            customer = (Customer) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No result");
        }
        return customer;
    }

    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("CUSTOMER.FIND_ALL").getResultList();
    }
}
