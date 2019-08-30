package com.meta.project.decorators;

import com.meta.project.entities.Attack;
import com.meta.project.entities.Pokemon;

public class PokemonTypeAttackDecorator extends AttackDecorator {
    private Attack decoratedAttack;
    private Pokemon pokemon;

    public PokemonTypeAttackDecorator(Attack decoratedAttack, Pokemon pokemon) {
        this.decoratedAttack = decoratedAttack;
        this.type = decoratedAttack.getType();
        this.pokemon = pokemon;
    }

    @Override
    public Double computeDamage() {
        Double damage = decoratedAttack.computeDamage();

        if (pokemon.getType().getClass() == this.type.getClass()) {
            damage = damage * 1.5;
        }

        return damage;
    }
}
