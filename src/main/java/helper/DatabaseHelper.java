package helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;
import javax.persistence.Persistence;

public class DatabaseHelper {

    private DatabaseHelper() {

    }

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
            instance.init();
        }

        return instance;
    }

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public boolean executeTransaction(Consumer<EntityManager> action) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            action.accept(entityManager);
            entityTransaction.commit();
        } catch (RuntimeException e) {
            System.err.println("Transaction error: " + e.getLocalizedMessage());
            entityTransaction.rollback();
            return false;
        }

        return true;
    }

    private boolean init() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error at initialing DatabaseManager: " + e.getMessage().toString());
            return false;
        }

        return true;
    }

}
