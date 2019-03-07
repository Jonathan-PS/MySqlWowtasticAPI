package no.jonathanps.wowtastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class DataHibernateApplication {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

	public static void main(String[] args) {

		/*System.out.println("Users:\n");
		for (User u: UserQueries.getUsers()) {
			System.out.println(u.toString());
		}

		System.out.println("\nCharacters:\n");
		for (Character c: CharacterQueries.getCharacters()) {
			System.out.println(c.toString());
		}

		System.out.println("\nClass Abilities:\n");
		for (ClassAbility ca: ClassAbilityQueries.getClassAbilities()) {
			System.out.println(ca.toString());
		}*/

		//System.out.println(CharacterQueries.getCharacter(1).toString());

/*		String inputClass = "Warrior";

		for(ClassAbility ca: ClassAbilityQueries.getClassAbility(inputClass)) {
			System.out.println(ca.toString());
		}*/
/*
		for(String s: ClassAbilityQueries.getUniqueClasses())
			System.out.println(s);
*/

		SpringApplication.run(DataHibernateApplication.class, args);
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}
}


/*
        // First we check whether given classname exists
        try {

        // Uppercase only first letter
        className = className.substring(0,1).toUpperCase() + className.substring(1);
        CharacterClass.valueOf(className);

        } catch (Exception e) {
            e.getMessage();
        }
 */