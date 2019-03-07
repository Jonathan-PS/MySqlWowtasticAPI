package no.jonathanps.wowtastic.queries;

import no.jonathanps.wowtastic.DataHibernateApplication;
import no.jonathanps.wowtastic.jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;


public class UserQueries {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = DataHibernateApplication.getEntityManagerFactory();

    public static List<User> getUsers(){
        List<User> userList = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            userList = manager.createQuery("SELECT s FROM User s", User.class).getResultList();

            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally {
            manager.close();
        }

        return userList;
    }


    public static User getUser(int userId) {
        User requestedUser = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            // query
            requestedUser = manager.find(User.class, userId);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally {
            manager.close();
        }

        return requestedUser;
    }

    public static void addUser(User newUser) {
        addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getUsername(), newUser.getPassword());
    }

    public static void addUser(String firstName, String lastName, String email, String username, String password){
        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            User newUser = new User();

            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);

            manager.persist(newUser);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }
}
