package com.meta.project.services;

import com.meta.project.Fight;
import com.meta.project.dtos.PokemonDTO;
import com.meta.project.entities.Pokemon;
import com.meta.project.entities.Type;
import com.meta.project.exceptions.InvalidPokemonTypeException;
import com.meta.project.exceptions.InvalidTeamException;
import com.meta.project.exceptions.PokemonNotFoundException;
import com.meta.project.factories.PokemonFactory;
import com.meta.project.factories.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    private TypeFactory typeFactory;
    private PokemonFactory pokemonFactory;

    @Autowired
    public FightService(TypeFactory typeFactory,
                        PokemonFactory pokemonFactory
    ) {
        this.typeFactory = typeFactory;
        this.pokemonFactory = pokemonFactory;
    }

    public Fight setType(String team, Integer pokemonId, String type) throws PokemonNotFoundException, InvalidTeamException, InvalidPokemonTypeException {
        final Fight fight = Fight.getInstance();
        final Type pokemonType = typeFactory.createType(type);

        fight.setPokemonType(team, pokemonId, pokemonType);

        return fight;
    }

    public Fight initialize() {
        final Fight fight = Fight.getInstance();


        return fight;
    }

    public Fight addPokemon(String team, PokemonDTO pokemonDTO) throws InvalidTeamException {
        final Fight fight = Fight.getInstance();

        final Pokemon pokemon = this.pokemonFactory.createFromDTO(pokemonDTO);
        fight.addPokemon(team, pokemon);

        return fight;
    }
}
