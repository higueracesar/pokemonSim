package com.meta.project.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pokemon {
    private String name;
    private Type type;
    private Integer level;

    private Integer HP;
    private Integer defense;
    private Integer specialDefense;
    private Integer attack;
    private Integer specialAttack;
    private Integer speed;
}
