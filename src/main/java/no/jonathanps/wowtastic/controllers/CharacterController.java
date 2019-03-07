package no.jonathanps.wowtastic.controllers;

import no.jonathanps.wowtastic.jpa.Character;
import no.jonathanps.wowtastic.queries.CharacterQueries;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @GetMapping("/character")
    public List<Character> getCharacters() {
        return CharacterQueries.getCharacters();
    }

    @GetMapping("/character/{characterId}")
    public Character getCharacter(@PathVariable int characterId) {
        return CharacterQueries.getCharacter(characterId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/character")
    public Character insertNewCharacter(@RequestBody Character newCharacter) {
        CharacterQueries.addCharacter(newCharacter);
        return newCharacter;
    }
}
