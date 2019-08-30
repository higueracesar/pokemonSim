package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class Fire extends Type {
    public Fire() {
        this.displayName = "Fire";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        if (type.getClass().equals(Fire.class)) {
            return 0.5;
        } else if (type.getClass().equals(Water.class)) {
            return 2d;
        }

        return 1d;
    }
}
