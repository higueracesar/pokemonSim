package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class Water extends Type {
    public Water() {
        this.displayName = "Dragon";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        if (type.getClass().equals(Water.class) || type.getClass().equals(Fire.class)) {
            return 0.5;
        } else if (type.getClass().equals(Plant.class)) {
            return 2d;
        }

        return 1d;
    }
}
