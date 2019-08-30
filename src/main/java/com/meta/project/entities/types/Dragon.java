package com.meta.project.entities.types;

import com.meta.project.Fight;
import com.meta.project.entities.Type;

public class Dragon extends Type {
    public Dragon() {
        this.displayName = "Dragon";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        if (type.getClass().equals(Dragon.class)) {
             return 2d;
        } else if (type.getClass().equals(Plant.class) || type.getClass().equals(Water.class) || type.getClass().equals(Fire.class)) {
            return 0.5;
        }

        return 1d;
    }
}
