package no.jonathanps.wowtastic.queries;

import no.jonathanps.wowtastic.DataHibernateApplication;
import no.jonathanps.wowtastic.jpa.Character;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CharacterQueries {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = DataHibernateApplication.getEntityManagerFactory();

    public static List<Character> getCharacters(){
        List<Character> characterList = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            characterList = manager.createQuery("SELECT s FROM Character s", Character.class).getResultList();

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

        return characterList;
    }

    public static Character getCharacter(int characterId){
        Character requestedCharacter = null;

        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            // Query
            requestedCharacter = manager.find(Character.class, characterId);

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
        return requestedCharacter;
    }

    public static void addCharacter(Character newCharacter) {
        addCharacter(newCharacter.getUserId(), newCharacter.getCharacterName(), newCharacter.getClassName(), newCharacter.getLevel());
    }


    public static void addCharacter(int userId, String characterName, String className, int level){
        EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            Character newCharacter = new Character();


            newCharacter.setUserId(userId);
            newCharacter.setCharacterName(characterName);
            newCharacter.setClassName(className);
            newCharacter.setLevel(level);

            manager.persist(newCharacter);

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
