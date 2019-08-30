package com.meta.project.decorators;

import com.meta.project.entities.Attack;
import com.meta.project.entities.Pokemon;

public class PokemonTypeDefenseDecorator extends AttackDecorator {
    private Attack decoratedAttack;
    private Pokemon pokemon;

    public PokemonTypeDefenseDecorator(Attack decoratedAttack, Pokemon pokemon) {
        this.decoratedAttack = decoratedAttack;
        this.type = decoratedAttack.getType();
        this.pokemon = pokemon;
    }

    @Override
    public Double computeDamage() {
        Double damage = decoratedAttack.computeDamage();
        damage = damage * pokemon.getType().computeAttackModifier(this.type);

        return damage;
    }
}
