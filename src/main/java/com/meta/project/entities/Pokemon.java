package com.meta.project.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pokemon {
    private String name;
    private Type type;
    private Integer level;

    private Double hp;
    private Integer defense;
    private Integer specialDefense;
    private Integer attack;
    private Integer specialAttack;
    private Integer speed;

    public void receiveAttack(Attack attack) {
        Double damage = attack.computeDamage();

        if (this.hp >= damage) {
            this.hp -= damage;
        } else {
            this.hp = 0d;
        }
    }
}
