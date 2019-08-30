package com.meta.project.entities;

import lombok.Getter;

@Getter
public abstract class Type {
    protected String displayName = "Type";

    public abstract Double computeAttackModifier(Type type);
}
