package com.meta.project.factories;

import com.meta.project.dtos.PokemonDTO;
import com.meta.project.entities.Pokemon;
import com.meta.project.entities.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonFactory {
    @Autowired
    private TypeFactory typeFactory;

    public Pokemon createFromDTO(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setLevel(pokemonDTO.getLevel());
        pokemon.setHP(pokemonDTO.getHP());
        pokemon.setAttack(pokemonDTO.getAttack());
        pokemon.setSpecialAttack(pokemonDTO.getSpecialAttack());
        pokemon.setDefense(pokemonDTO.getDefense());
        pokemon.setSpecialDefense(pokemonDTO.getSpecialDefense());
        pokemon.setSpeed(pokemonDTO.getSpeed());

        Type type = typeFactory.createType(pokemonDTO.getType());
        pokemon.setType(type);

        return pokemon;
    }
}
