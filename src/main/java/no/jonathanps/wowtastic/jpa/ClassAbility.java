package no.jonathanps.wowtastic.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_abilities")
public class ClassAbility {

    @Id
    @Column(name = "class_ability_id")
    private int classAbilityId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "ability")
    private String ability;

    public int getClassAbilityId() {
        return classAbilityId;
    }

    public void setClassAbilityId(int classAbilityId) {
        this.classAbilityId = classAbilityId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return classAbilityId + "\t" + className + "\t" + ability;
    }
}
