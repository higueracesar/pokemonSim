package com.meta.project.entities;

import lombok.Getter;

@Getter
public abstract class Attack {
    protected String displayName;
    protected String value;
    protected Type type;
    protected Double baseStrength;

    public Double computeDamage() {
        return this.baseStrength;
    }
}
