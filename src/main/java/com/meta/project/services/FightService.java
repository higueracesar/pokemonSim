package com.meta.project.services;

import com.meta.project.Fight;
import com.meta.project.dtos.AttackDTO;
import com.meta.project.dtos.PokemonDTO;
import com.meta.project.entities.Attack;
import com.meta.project.entities.Pokemon;
import com.meta.project.entities.Type;
import com.meta.project.exceptions.InvalidPokemonTypeException;
import com.meta.project.exceptions.InvalidTeamException;
import com.meta.project.exceptions.PokemonNotFoundException;
import com.meta.project.factories.AttackFactory;
import com.meta.project.factories.PokemonFactory;
import com.meta.project.factories.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    private TypeFactory typeFactory;
    private PokemonFactory pokemonFactory;
    private AttackFactory attackFactory;

    @Autowired
    public FightService(TypeFactory typeFactory,
                        PokemonFactory pokemonFactory,
                        AttackFactory attackFactory
    ) {
        this.typeFactory = typeFactory;
        this.pokemonFactory = pokemonFactory;
        this.attackFactory = attackFactory;
    }

    public Fight performAttack(String team, Integer pokemonId, AttackDTO attackDTO) throws InvalidTeamException {
        final Fight fight = Fight.getInstance();

        final Pokemon attackingPokemon = fight.retrievePokemon(team, pokemonId);
        final Pokemon defendingPokemon = fight.retrieveDefendingPokemon(team);
        final Attack attack = this.attackFactory.createWrappedAttack(attackingPokemon, defendingPokemon, fight.getWeather(), attackDTO.getValue());

        defendingPokemon.receiveAttack(attack);

        return fight;
    }

    public Fight setType(String team, Integer pokemonId, String type) throws PokemonNotFoundException, InvalidTeamException {
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
