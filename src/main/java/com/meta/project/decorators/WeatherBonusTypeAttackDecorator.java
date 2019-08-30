package com.meta.project.decorators;

import com.meta.project.entities.Attack;
import com.meta.project.entities.Pokemon;
import com.meta.project.entities.Weather;

public class WeatherBonusTypeAttackDecorator extends AttackDecorator {
    private Attack decoratedAttack;
    private Weather weather;

    public WeatherBonusTypeAttackDecorator(Attack decoratedAttack, Weather weather) {
        this.decoratedAttack = decoratedAttack;
        this.type = decoratedAttack.getType();
        this.weather = weather;
    }

    @Override
    public Double computeDamage() {
        Double damage = decoratedAttack.computeDamage();

        if (weather.getBonusOnType().getClass() == this.type.getClass()) {
            damage = damage * weather.getBonus();
        }

        return damage;
    }
}
