package no.jonathanps.wowtastic.jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @Column(name = "character_id", unique = true)
    private int characterId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "character_name", nullable = false)
    private String characterName;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "level", nullable = false)
    private int level;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return characterId + "\t" + userId  + "\t" + characterName  + "\t" + className  + "\t" + level;
    }
}
