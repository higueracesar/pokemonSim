package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class Rock extends Type {
    public Rock() {
        this.displayName = "Rock";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        if (type.getClass().equals(Rock.class) || type.getClass().equals(Fire.class)) {
            return 0.5;
        } else if (type.getClass().equals(Plant.class) || type.getClass().equals(Water.class)) {
            return 2d;
        }

        return 1d;
    }
}
