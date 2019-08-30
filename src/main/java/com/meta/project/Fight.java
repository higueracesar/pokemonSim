package com.meta.project;

import com.meta.project.entities.*;
import com.meta.project.entities.weathers.NoWeather;
import com.meta.project.exceptions.InvalidTeamException;
import com.meta.project.exceptions.PokemonNotFoundException;
import com.meta.project.factories.TypeFactory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class Fight {
    private static Fight instance;

    private Weather weather;
    private Team first;
    private Team second;

    private Fight() {}

    public static Fight getInstance() {
        if (instance == null) {
            instance = new Fight();

            buildBaseFight();
        }

        return instance;
    }

    private static void buildBaseFight() {
        instance.first = new Team();
        instance.second = new Team();
        instance.weather = new NoWeather(TypeFactory.createTypeStatic("NullType"));
    }

    public void setPokemonType(@NotNull String teamName, Integer pokemonId, Type type) throws InvalidTeamException, PokemonNotFoundException {
        Team team = selectTeam(teamName);

        team.setPokemonType(pokemonId, type);
    }

    private Team selectTeam(@NotNull String teamName) throws InvalidTeamException {
        Team team;

        if (teamName.toLowerCase().equals("first")) {
            team = first;
        } else if (teamName.toLowerCase().equals("second")) {
            team = second;
        } else {
            throw new InvalidTeamException();
        }

        return team;
    }

    public void addPokemon(String team, Pokemon pokemon) throws InvalidTeamException {
        selectTeam(team).add(pokemon);
    }

    public Pokemon retrievePokemon(String teamName, Integer pokemonId) throws InvalidTeamException {
        Team team = selectTeam(teamName);
        return team.retrievePokemon(pokemonId);
    }

    public Pokemon retrieveDefendingPokemon(String teamName) throws InvalidTeamException {
        Team team = selectTeam(teamName);

        if (team == first) {
            team = second;
        } else {
            team = first;
        }

        return team.getPokemons().values().iterator().next();
    }
}
