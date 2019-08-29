package com.meta.project.entities;

public abstract class Attack {
    protected String displayName;
    protected Type type;
    protected Double baseStrength;

    public abstract Double computeDamage();
}
