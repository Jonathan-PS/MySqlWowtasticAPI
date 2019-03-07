package no.jonathanps.wowtastic.controllers;

import no.jonathanps.wowtastic.jpa.ClassAbility;
import no.jonathanps.wowtastic.queries.ClassAbilityQueries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassAbilityController {
    @GetMapping("/class-ability")
    public List<ClassAbility> classAbilitiesGet(){
        return ClassAbilityQueries.getClassAbilities();
    }

    @GetMapping("/class")
    public List<String> classAbilitiesUniqueGet(){
        return ClassAbilityQueries.getUniqueClasses();
    }

    @GetMapping("/class/{className}")
    public List<ClassAbility> classAbilityGet(@PathVariable String className) {
        return ClassAbilityQueries.getClassAbility(className);
    }
}
