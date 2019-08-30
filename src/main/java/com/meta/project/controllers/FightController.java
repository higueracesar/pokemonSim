package com.meta.project.controllers;

import com.meta.project.Fight;
import com.meta.project.dtos.PokemonDTO;
import com.meta.project.entities.Type;
import com.meta.project.exceptions.InvalidPokemonTypeException;
import com.meta.project.exceptions.InvalidTeamException;
import com.meta.project.exceptions.PokemonNotFoundException;
import com.meta.project.services.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("fight")
public class FightController {

    @Autowired
    private FightService fightService;

    @GetMapping(path = "id")
    public String attack() {


        return "Attacking, Bitch!";
    }

    @PostMapping("{team}/{pokemonId}/{type}")
    public Fight setType(@PathVariable("team") String team,
                         @PathVariable("pokemonId") Integer pokemonId,
                         @PathVariable("type") String type) throws PokemonNotFoundException, InvalidTeamException {
        return fightService.setType(team, pokemonId, type);
    }

    @PostMapping("{team}")
    public Fight addPokemon(
            @PathVariable("team") String team,
            @RequestBody PokemonDTO pokemonDTO) throws InvalidPokemonTypeException, InvalidTeamException {
        return fightService.addPokemon(team, pokemonDTO);
    }

    @PutMapping(path = "begin")
    public Fight initializeFight() {
        return fightService.initialize();
    }
}
