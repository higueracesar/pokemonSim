package com.meta.project.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PokemonDTO {
    private String name;
    private String type;
    private Integer level;

    private Double HP;
    private Integer defense;
    private Integer specialDefense;
    private Integer attack;
    private Integer specialAttack;
    private Integer speed;
}
