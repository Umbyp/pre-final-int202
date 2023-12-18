package int202.prefinalint202.repositories;

import int202.prefinalint202.entities.Office;
import int202.prefinalint202.utilities.EntityManagerBuilder;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OfficeRepositoy {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }
}
