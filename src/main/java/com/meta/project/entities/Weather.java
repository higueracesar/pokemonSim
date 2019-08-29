package com.meta.project.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Weather {
    protected String displayName = "Weather";

    private Type bonusOnType;
    private double bonus = 0.1;

    public Weather(Type bonusOnType) {
        this.bonusOnType = bonusOnType;
    }
}
