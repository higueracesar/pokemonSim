package com.meta.project.factories;

import com.meta.project.decorators.PokemonTypeAttackDecorator;
import com.meta.project.decorators.PokemonTypeDefenseDecorator;
import com.meta.project.decorators.WeatherBonusTypeAttackDecorator;
import com.meta.project.entities.Attack;
import com.meta.project.entities.Pokemon;
import com.meta.project.entities.Weather;
import com.meta.project.entities.attacks.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class AttackFactory {
    public Attack createAttack(String attackName) {
        switch (attackName) {
            case "FlameThrower":
                return new FlameThrower();
            case "HydroPump":
                return new HydroPump();
            case "IceBeam":
                return new IceBeam();
            case "QuickAttack":
                return new QuickAttack();
            case "VineWhip":
                return new VineWhip();
            default:
                return new NullAttack();
        }
    }

    public ArrayList<Attack> oneOfEachNonNullAttacks() {
        ArrayList<Attack> attacks = new ArrayList<>();

        Arrays.asList("FlameThrower","HydroPump","IceBeam","QuickAttack","VineWhip")
                .forEach(name -> attacks.add(createAttack(name)));

        return attacks;
    }

    public Attack createWrappedAttack(Pokemon attackingPokemon, Pokemon defendingPokemon, Weather weather, String attackValue) {
        Attack attack = this.createAttack(attackValue);
        attack = new PokemonTypeAttackDecorator(attack, attackingPokemon);
        attack = new PokemonTypeDefenseDecorator(attack, defendingPokemon);
        attack = new WeatherBonusTypeAttackDecorator(attack, weather);

        return attack;
    }
}
