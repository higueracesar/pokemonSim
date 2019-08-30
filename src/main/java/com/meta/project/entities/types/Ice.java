package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class Ice extends Type {
    public Ice() {
        this.displayName = "Dragon";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        if (type.getClass().equals(Ice.class) || type.getClass().equals(Water.class)) {
            return 0.5;
        } else if (type.getClass().equals(Fire.class)) {
            return 2d;
        }

        return 1d;
    }
}
