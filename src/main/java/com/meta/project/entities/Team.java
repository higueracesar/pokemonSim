package com.meta.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meta.project.exceptions.PokemonNotFoundException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Random;

@Getter
public class Team {
    private HashMap<Integer, Pokemon> pokemons;

    @JsonIgnore
    private Random random;

    public Team (Pokemon pokemon) {
        random = new Random();

        pokemons = new HashMap<>();
        pokemons.put(random.nextInt(), pokemon);
    }

    public Team() {
        random = new Random();

        pokemons = new HashMap<>();
    }

    public void add(Pokemon pokemon) {
        int randomKey = random.nextInt() & Integer.MAX_VALUE;

        while (pokemons.containsKey(randomKey)) {
            randomKey = random.nextInt();
        }

        pokemons.put(randomKey, pokemon);
    }

    public void setPokemonType(Integer pokemonId, Type type) throws PokemonNotFoundException {
        if (!pokemons.containsKey(pokemonId)) {
            throw new PokemonNotFoundException();
        }

        pokemons.get(pokemonId).setType(type);
    }

    public Pokemon retrievePokemon(Integer pokemonId) {
        return pokemons.get(pokemonId);
    }
}
