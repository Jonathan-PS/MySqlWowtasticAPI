package no.jonathanps.wowtastic.queries;

import no.jonathanps.wowtastic.DataHibernateApplication;
import no.jonathanps.wowtastic.jpa.ClassAbility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClassAbilityQueries {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = DataHibernateApplication.getEntityManagerFactory();

    /**
     *
     * @return all elements of table class_abilities
     */
    public static List<ClassAbility> getClassAbilities(){
        List<ClassAbility> classAbilityList = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            classAbilityList = manager.createQuery("SELECT s FROM ClassAbility s", ClassAbility.class).getResultList();

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

        return classAbilityList;
    }


    /**
     *
     * @param className
     * @return every table entry, in table class_abilities, where class_name equals given @param
     */
    public static List<ClassAbility> getClassAbility(String className){
        List<ClassAbility> classAbilityList = null;

        // Make sure the query takes in the right classname
        if (className.length() < 2)
            return classAbilityList;
        className = className.substring(0,1).toUpperCase() + className.substring(1);


        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            // Query
            classAbilityList = manager.createQuery("SELECT s FROM ClassAbility s WHERE s.className = :name", ClassAbility.class).setParameter("name", className).getResultList();

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

        return classAbilityList;
    }

    /**
     * Returns all unique classes that are instantiated in the database
     * @return
     */
    public static List<String> getUniqueClasses() {
        List<String> uniqueClasses = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            // Query
            uniqueClasses = manager.createQuery("SELECT DISTINCT s.className FROM ClassAbility s", String.class).getResultList();

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

            return uniqueClasses;
    }

    /**
     * Adds a new class ability to the table class_ability.
     * @param className
     * @param ability
     */
    public static void addClassAbility(String className, String ability){
        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            ClassAbility classAbility = new ClassAbility();

            classAbility.setClassName(className);
            classAbility.setAbility(ability);

            manager.persist(classAbility);

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
